package com.example.movieCatalog_service;

import com.example.movieCatalog_service.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamService {
    @Autowired
    private StreamRepo streamRepo;
    public List<MovieInfo> saveall(List<MovieInfo> movieInfos) {
        streamRepo.saveAll(movieInfos);
        return movieInfos;
    }

    public List<MovieInfo> getAll() {
        return streamRepo.findAll();
    }

    public Optional<MovieInfo> findMovieById(Long pathid) {
        return streamRepo.findById(pathid);
    }
}
