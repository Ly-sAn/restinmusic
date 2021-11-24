package com.example.restinmusic.repositories;

import com.example.restinmusic.models.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlbumRepository {

    public List<Album> getAll();
    public Album getOneById(int id);
    /*
    public int createOne(Album album);
    public int updateOneById(int id);
    public int deleteOneById(int id);

     */
}
