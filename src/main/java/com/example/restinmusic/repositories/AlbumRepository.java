package com.example.restinmusic.repositories;

import com.example.restinmusic.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AlbumRepository implements IAlbumRepository {

    @Autowired
    private JdbcTemplate jbcdTemplate;

    public List<Album> getAll(){
        final String query = "SELECT id, name, release_date as releaseDate FROM album";
        return jbcdTemplate.query(query, BeanPropertyRowMapper.newInstance(Album.class));
    }

    public Album getOneById(int id){
        final String query = "SELECT id, name, release_date as releaseDate FROM album WHERE id = ?";
        return jbcdTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Album.class), id);
    }
    /*

    public int createOne(Album album){
        return int;
    }

    public int updateOneById(int id){
        return int;
    }

    public int deleteOneById(int id){
        return int;
    }

     */


    }
