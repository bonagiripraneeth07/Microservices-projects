package com.example.movieCatalog_service;

import com.example.movieCatalog_service.model.MovieInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController

@CrossOrigin
public class StreamController {
    @Autowired
    private StreamService streamService;
    @PostMapping("/movieinfo/save")
     public List<MovieInfo> saveall(@RequestBody List<MovieInfo> movieInfos){
        return streamService.saveall(movieInfos);

    }
    @GetMapping("movie-info-list")
    public  List<MovieInfo> getAll(){
        return streamService.getAll();
    }

    @GetMapping("movie-info/find-path-by-id/{pathid}")
    public  String findMovieId(@PathVariable Long pathid )
    {
         Optional<MovieInfo> videoInfoOpitional = streamService.findMovieById(pathid);
        System.out.println(videoInfoOpitional.map(MovieInfo::getPath));
        return videoInfoOpitional.get().getPath();
    }


}
