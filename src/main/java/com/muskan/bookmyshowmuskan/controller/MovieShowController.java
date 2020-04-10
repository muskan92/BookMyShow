package com.muskan.bookmyshowmuskan.controller;

import com.muskan.bookmyshowmuskan.annotation.IsAuthorized;
import com.muskan.bookmyshowmuskan.bo.MovieShowPayload;
import com.muskan.bookmyshowmuskan.bo.TicketPayload;
import com.muskan.bookmyshowmuskan.bo.UserSession;
import com.muskan.bookmyshowmuskan.entity.MovieShow;
import com.muskan.bookmyshowmuskan.entity.Ticket;
import com.muskan.bookmyshowmuskan.service.MovieShowService;
import com.muskan.bookmyshowmuskan.service.TheatreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movieShow")
public class MovieShowController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieShowService movieShowService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private UserSession userSession;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<MovieShow> addMovieShow(@RequestBody MovieShowPayload movieShowPayload){

        MovieShow movieShow = movieShowService.addMovieShow(movieShowPayload);

        return new ResponseEntity<>(movieShow,HttpStatus.OK);

    }
    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<MovieShow>> getAllMovieShow(){

        List<MovieShow> movieShows = movieShowService.getAllMovieShow();
        return new ResponseEntity<>(movieShows, HttpStatus.OK);
    }

    @IsAuthorized
    @RequestMapping(path = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieShow> getMovieShowById(@PathVariable int id){

        MovieShow movieShows = movieShowService.getMovieShowById(id);
        return new ResponseEntity<>(movieShows, HttpStatus.OK);
    }

    @IsAuthorized
    @RequestMapping(path = "/bookTicket", method = RequestMethod.POST)
    public ResponseEntity<Ticket> bookMovieShow(@RequestBody TicketPayload ticketPayload){

        /*if(!userSession.isLoggedIn()){
            logger.error("login before booking");
            throw new UserNotAuthorizedException("login before booking");
        }*/
        logger.info("address of movieShowService {}",movieShowService);
        logger.info("controller-address of theatreService {}",theatreService);
        logger.info("controller-address of theatreService {}",theatreService);
        logger.info("controller-address of theatreService {}",theatreService);

        Ticket ticket = movieShowService.bookTicket(ticketPayload);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
}
