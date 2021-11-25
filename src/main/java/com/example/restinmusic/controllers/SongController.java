package com.example.restinmusic.controllers;

import com.example.restinmusic.models.Song;
import com.example.restinmusic.repositories.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongRepository songRepository;

    @GetMapping(value = "")
    public ResponseEntity<List> getSongs(
            @RequestParam(required = false) String asc ,
            @RequestParam(required = false) String desc,
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String duration,
            @RequestParam(required = false) Date releaseDate ,
            @RequestParam(required = false) Integer albumId
    ){
        List<Song> list = songRepository.getAll(asc,desc, id, name, artist, category, duration, releaseDate, albumId);
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

    @GetMapping(value = "/orders")
    public ResponseEntity<List> getPaginated(
            @RequestParam("range") String range
            ){
        String[] rangeArray = range.split("-");

        int from = Integer.parseInt(rangeArray[0]);
        int to = Integer.parseInt(rangeArray[1]);
        int total = to - from;
        List<Song> list = songRepository.getAllRanged(from, to);
        int listSize = songRepository.getSize();
        String prev = String.valueOf(from - total - 1) + "-" +String.valueOf(to - total - 1);
        String next = String.valueOf(from + total + 1) + "-" +String.valueOf(to + total + 1);
        String last = String.valueOf(listSize -1 - total) + "-" + String.valueOf(listSize -1) ;
        String first = "0-" + String.valueOf(total);

        Map<String,String> map = new HashMap<String,String>();
        map.put("first", first);
        map.put("prev", prev);
        map.put("next", next);
        map.put("last",last);

        String link = "" ;
        for (var entry : map.entrySet()) {
            if (entry.getKey() == "prev" && (from - total - 1) < 0){
                continue;
            }
            if (entry.getKey() == "next" && (to+total+1) >= listSize){
                continue;
            }
            link = link.concat("<http://localhost:8080/songs/orders?range="+entry.getValue()+">; rel="+entry.getKey()+", ");
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("Content-Range", range);
        responseHeader.set("Accepted-Range", String.valueOf(total));
        responseHeader.set("Link", link);


        return ResponseEntity.ok().headers(responseHeader).body(list);
    }

}
