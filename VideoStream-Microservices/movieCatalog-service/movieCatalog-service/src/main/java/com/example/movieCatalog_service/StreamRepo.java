package com.example.movieCatalog_service;

import com.example.movieCatalog_service.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepo extends JpaRepository<MovieInfo,Long> {
}
