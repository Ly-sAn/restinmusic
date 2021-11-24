package com.example.restinmusic.controllers;

import com.example.restinmusic.models.Song;
import com.example.restinmusic.repositories.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongRepository songRepository;

    @GetMapping("")
    public ResponseEntity<List> getSongs(){
        List<Song> list = songRepository.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Song> getOneById(@PathVariable int id){
        Song song = songRepository.getOneById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createSong(@RequestBody Song song){
        int res = songRepository.createOne(song);
        if(res == 1){
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneSong(@PathVariable int id){
        int res = songRepository.deleteOneById(id);
        if (res == 1){
            return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT) ;
        }
        else {
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOneSong(@PathVariable int id, @RequestBody Song song){
        int res = songRepository.updateOneById(id,song);
        if (res == 1){
            return new ResponseEntity<>("Modified", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
        }
    }

}
