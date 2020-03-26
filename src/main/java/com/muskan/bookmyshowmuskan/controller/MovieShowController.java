package com.muskan.bookmyshowmuskan.controller;

import com.muskan.bookmyshowmuskan.bo.MovieShow;
import com.muskan.bookmyshowmuskan.bo.Ticket;
import com.muskan.bookmyshowmuskan.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movieShow")
public class MovieShowController {

    @Autowired
    private MovieShowService movieShowService;

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<MovieShow>> getAllMovieShow(){

        List<MovieShow> movieShows = movieShowService.getAllMovieShow();
        return new ResponseEntity<>(movieShows, HttpStatus.OK);
    }

    @RequestMapping(path = "/book/{seatCount}/{movieShowId}", method = RequestMethod.GET)
    public ResponseEntity<Ticket> bookMovieShow(@PathVariable("seatCount") int seatCount,@PathVariable("movieShowId") int movieShowId){

        Ticket ticket = movieShowService.bookMovieShow(movieShowId,seatCount);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
}
