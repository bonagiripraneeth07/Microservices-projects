package com.example.movie_streaming_service.openFeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;

@FeignClient(name = "moviecatalog-service")
public interface StreamInterface {
    @GetMapping("movie-info/find-path-by-id/{pathid}")
    String findMovieId(@PathVariable("pathid") Long pathid);

}
