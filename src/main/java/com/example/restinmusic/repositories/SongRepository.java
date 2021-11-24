package com.example.restinmusic.repositories;

import com.example.restinmusic.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SongRepository implements ISongRepository {

    @Autowired
    private JdbcTemplate jbcdTemplate;

    public List<Song> getAll(){
        final String query = "SELECT id, name, artist, category, duration , release_date as releaseDate, album_id as albumId FROM song;";
        return jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Song.class));
    }

    public Song getOneById(int id){
        final String query = "SELECT id, name, artist, category, duration , release_date as releaseDate, album_id as albumId FROM song WHERE id = ?;";
        return jbcdTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Song.class), id);
    }

    public int deleteOneById(int id){
        final String query = "DELETE FROM song WHERE id = ? ;";
        return jbcdTemplate.update(query,id);
    }

    public int createOne(Song song){
        final String query = "INSERT INTO song (name, artist, category, duration, release_date, album_id) values (?,?,?,?,?,?);";
        return jbcdTemplate.update(query, song.getName(), song.getArtist(), song.getCategory(), song.getDuration(), song.getReleaseDate(), song.getAlbumId());
    }

    public int updateOneById(int id, Song song){
        final String query = "UPDATE song SET name = ?, artist = ?, category = ?, duration = ?, release_date = ?, album_id = ? WHERE id = ?;";
        return jbcdTemplate.update(query,song.getName(),song.getArtist(),song.getCategory(),song.getDuration(),song.getReleaseDate(),song.getAlbumId(),id);
    }

}
