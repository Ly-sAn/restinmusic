package com.example.restinmusic.repositories;

import com.example.restinmusic.models.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ISongRepository{

    public List<Song> getAll();
    public Song getOneById(int id);
    public int deleteOneById(int id);
    public int createOne(Song song);
    public int updateOneById(int id, Song song);

}
