package com.example.restinmusic.repositories;

import com.example.restinmusic.models.Song;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface ISongRepository{

    public int getSize();
    public List<Song> getAll(String asc, String desc, Integer id, String name, String artist, String category, String duration, Date releaseDate, Integer albumId);
    public Song getOneById(int id);
    public int deleteOneById(int id);
    public int createOne(Song song);
    public int updateOneById(int id, Song song);
    public List<Song> getAllRanged(int from, int to);
}
