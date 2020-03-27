package com.muskan.bookmyshowmuskan.controller;

import com.muskan.bookmyshowmuskan.bo.TicketPayload;
import com.muskan.bookmyshowmuskan.entity.MovieShow;
import com.muskan.bookmyshowmuskan.entity.Ticket;
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
//getMovieShowById

    @RequestMapping(path = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieShow> getMovieShowById(@PathVariable int id){

        MovieShow movieShows = movieShowService.getMovieShowById(id);
        return new ResponseEntity<>(movieShows, HttpStatus.OK);
    }


    @RequestMapping(path = "/book", method = RequestMethod.POST)
    public ResponseEntity<Ticket> bookMovieShow(@RequestBody TicketPayload ticketPayload){

        Ticket ticket = movieShowService.bookMovieShow(ticketPayload.getMovieShowId(),ticketPayload.getHeadCount());
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
}
