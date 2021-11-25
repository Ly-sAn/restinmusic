package com.example.restinmusic.repositories;

import com.example.restinmusic.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Repository
public class SongRepository implements ISongRepository {

    @Autowired
    private JdbcTemplate jbcdTemplate;

    public int getSize(){
        String query = "SELECT id, name, artist, category, duration ," +
                " release_date as releaseDate, album_id as albumId FROM song ";
        List<Song> list = jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Song.class));
        return list.size();
    }

    public List<Song> getAll(String asc, String desc, Integer id, String name, String artist, String category, String duration, Date releaseDate, Integer albumId) {
        String query = "SELECT id, name, artist, category, duration ," +
                " release_date as releaseDate, album_id as albumId FROM song ";
        List<String> columns = Arrays.asList("id", "name", "artist", "category", "duration", "release_date", "album_id");

        if (columns.contains(asc) || columns.contains(desc) ) {
            if (asc != null && desc != null) {
                query += "ORDER BY " + asc + " ASC, " + desc + " DESC";
                System.out.println(query);
                return jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Song.class));
            } else if (desc != null) {
                query += "ORDER BY " + desc + " DESC";
                return jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Song.class));
            } else if (asc != null) {
                query += "ORDER BY " + asc + " ASC";
                return jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Song.class));
            }
        } else {
            return jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Song.class));
        }
        return jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Song.class));
    }

    public Song getOneById(int id) {
        final String query = "SELECT id, name, artist, category, duration , release_date as releaseDate," +
                " album_id as albumId FROM song WHERE id = ?;";
        return jbcdTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Song.class), id);
    }

    public int deleteOneById(int id) {
        final String query = "DELETE FROM song WHERE id = ? ;";
        return jbcdTemplate.update(query, id);
    }

    public int createOne(Song song) {
        final String query = "INSERT INTO song (name, artist, category, duration, release_date, album_id) values (?,?,?,?,?,?);";
        return jbcdTemplate.update(query, song.getName(), song.getArtist(), song.getCategory(), song.getDuration(), song.getReleaseDate(), song.getAlbumId());
    }

    public int updateOneById(int id, Song song) {
        final String query = "UPDATE song SET name = ?, artist = ?, category = ?, duration = ?, release_date = ?, album_id = ? WHERE id = ?;";
        return jbcdTemplate.update(query, song.getName(), song.getArtist(), song.getCategory(), song.getDuration(), song.getReleaseDate(), song.getAlbumId(), id);
    }

    public List<Song> getAllRanged(int from, int to) {
        final String query = "SELECT id, name, artist, category, duration , release_date as releaseDate, album_id as albumId FROM song LIMIT ?,?;";
        return jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Song.class), from, to);
    }
}
