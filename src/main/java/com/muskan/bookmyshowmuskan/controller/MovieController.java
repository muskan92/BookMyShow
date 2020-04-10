package com.muskan.bookmyshowmuskan.controller;

import com.muskan.bookmyshowmuskan.entity.Movie;
import com.muskan.bookmyshowmuskan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Movie")
public class MovieController {

    //add,get movie
    @Autowired
    private MovieService movieService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){

        Movie movie1 = movieService.addMovie(movie);
        return new ResponseEntity<>(movie1, HttpStatus.OK);
    }
}
