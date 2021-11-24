package com.example.restinmusic.controllers;

import com.example.restinmusic.models.Album;
import com.example.restinmusic.repositories.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private IAlbumRepository albumRepository;

    @GetMapping("")
    public List<Album> getAlbums(){
         return albumRepository.getAll();
    }

    @GetMapping("/{id}")
    public Album getOneAlbum(@PathVariable int id){
        return albumRepository.getOneById(id);
    }
    /*

    @PostMapping("")
    public void createAlbum(Album album){
        int response = albumRepository.createOne(album);
    }


    @PutMapping("/{id}")
    public void updateOneAlbum(int id){
        int response = albumRepository.updateOneById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOneAlbum(int id){
        int response = albumRepository.deleteOneById(id);
    }

     */
}
