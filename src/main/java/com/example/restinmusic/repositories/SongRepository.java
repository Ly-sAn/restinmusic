package com.example.restinmusic.repositories;

import com.example.restinmusic.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;


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

    public List<Song> getAll(HashMap<String, Object> paramsList) {


        String query = "SELECT id, name, artist, category, duration ," +
                " release_date as releaseDate, album_id as albumId FROM song ";

        List<String> columns = Arrays.asList("name", "artist", "category", "duration", "release_date");
        List<Object> toSendParams = new ArrayList<Object>();

        String clauses = "";

        for (var entry : paramsList.entrySet()) {
            if (!columns.contains(entry.getKey())){
                continue;
            }
            clauses += entry.getKey() + " LIKE '%" + entry.getValue() + "%' AND ";
            toSendParams.add(entry.getValue());
        }

        if (!toSendParams.isEmpty()){
            query+= " WHERE " + clauses;
            query = query.substring(0, query.length() -5);
        }

        if (paramsList.containsKey("asc") || paramsList.containsKey("desc")) {
            if (paramsList.get("asc") != null && paramsList.get("desc") != null) {
                query += "ORDER BY " + paramsList.get("asc") + " ASC, " + paramsList.get("desc") + " DESC";
                System.out.println(query);
            } else if (paramsList.get("desc") != null) {
                query += "ORDER BY " + paramsList.get("desc") + " DESC";
            } else if (paramsList.get("asc") != null) {
                query += "ORDER BY " + paramsList.get("asc") + " ASC";
            }
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
