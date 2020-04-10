package com.muskan.bookmyshowmuskan.service;

import com.muskan.bookmyshowmuskan.entity.Movie;
import com.muskan.bookmyshowmuskan.exception.MovieAlreadyExistException;
import com.muskan.bookmyshowmuskan.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {

       Optional<Movie> movieByName = movieRepository.findByTitle(movie.getTitle());

       if(movieByName.isPresent()){
           logger.error("Movie already exist with the name: "+movie.getTitle());
           throw new MovieAlreadyExistException("Movie already exist with the name: "+movie.getTitle());
       }else{
          return movieRepository.save(movie);
       }

    }
}
