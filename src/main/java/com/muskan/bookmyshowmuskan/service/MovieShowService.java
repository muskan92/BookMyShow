package com.muskan.bookmyshowmuskan.service;

import com.muskan.bookmyshowmuskan.entity.MovieShow;
import com.muskan.bookmyshowmuskan.entity.Ticket;
import com.muskan.bookmyshowmuskan.repository.MovieShowRepository;
import com.muskan.bookmyshowmuskan.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public MovieShow getMovieShowById(int id) {

        Optional<MovieShow> movieShow = movieShowRepository.findById(id);
        return movieShow.get();
    }


    public Ticket bookMovieShow(int movieShowId,int headCount) {

        Ticket ticket = new Ticket();

        MovieShow movieShow = getMovieShowById(movieShowId);

        ticket.setMovieName(movieShow.getMovie().getTitle());
        ticket.setTheatreName(movieShow.getTheatre().getName());
        ticket.setScreenNumber(movieShow.getScreenNumber());
        ticket.setShowTime(movieShow.getShowTime());
        movieShow.setSeatcount(movieShow.getSeatcount()-headCount);
        ticket.setSeatNumber(movieShow.getSeatcount() +"to"+ movieShow.getSeatcount()+1);

        movieShowRepository.save(movieShow);
        return ticketRepository.save(ticket);

    }
}
