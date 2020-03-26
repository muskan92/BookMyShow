package com.muskan.bookmyshowmuskan.service;

import com.muskan.bookmyshowmuskan.bo.MovieShow;
import com.muskan.bookmyshowmuskan.bo.Ticket;
import com.muskan.bookmyshowmuskan.repository.MovieShowRepository;
import com.muskan.bookmyshowmuskan.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovieShowService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public List<MovieShow> getAllMovieShow() {

        List<MovieShow> movieShows = movieShowRepository.findAll();
        return movieShows;
    }

    public Ticket bookMovieShow(int movieShowId,int seatCount) {

        Ticket ticket = null;
        Optional<MovieShow> movieShow = movieShowRepository.findById(movieShowId);

        ticket.setMovieName(movieShow.get().getMovie().getTitle());
        ticket.setTheatreName(movieShow.get().getTheatre().getName());
        ticket.setScreenNumber(movieShow.get().getScreenNumber());
        ticket.setShowTime(movieShow.get().getShowTime());
        movieShow.get().setSeatcount(movieShow.get().getSeatcount()-seatCount);
        ticket.setSeatNumber(movieShow.get().getSeatcount() +"to"+ movieShow.get().getSeatcount()+1);

        movieShowRepository.save(movieShow.get());
        return ticketRepository.save(ticket);

    }
}
