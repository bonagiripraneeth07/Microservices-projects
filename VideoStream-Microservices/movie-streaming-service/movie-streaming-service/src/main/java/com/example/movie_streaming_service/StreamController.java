package com.example.movie_streaming_service;

import com.example.movie_streaming_service.openFeign.StreamInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.rmi.MarshalledObject;
@CrossOrigin
@RequestMapping("/movie-stream")
@RestController
public class StreamController {
    @Autowired
    private StreamInterface streaminterface ;
    private static final String directory = "C:\\Users\\prane\\Downloads\\temp-stream-Ms\\";
    @GetMapping("/stream/{videoPath}")
    public ResponseEntity<InputStreamResource> Streamvideo(@PathVariable String videoPath) throws FileNotFoundException {

        File file = new File(directory+videoPath);
        System.out.println(videoPath);
        if (file.exists()) {
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(inputStreamResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/play/{pathid}")
    public ResponseEntity<InputStreamResource>  streamVideoById(@PathVariable long pathid )throws FileNotFoundException{
        System.out.println(pathid);
        String moviePath =streaminterface.findMovieId(pathid);
        System.out.println(moviePath);
        File file = new File(directory+moviePath);
        System.out.println(directory+moviePath);
        System.out.println(moviePath);
        if (file.exists()) {
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(inputStreamResource);
        } else {
            return ResponseEntity.notFound().build();
        }

    }



}
