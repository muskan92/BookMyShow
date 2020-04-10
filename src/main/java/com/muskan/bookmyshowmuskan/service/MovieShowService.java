package com.muskan.bookmyshowmuskan.service;

import com.muskan.bookmyshowmuskan.bo.MovieShowPayload;
import com.muskan.bookmyshowmuskan.bo.TicketPayload;
import com.muskan.bookmyshowmuskan.entity.*;
import com.muskan.bookmyshowmuskan.exception.MovieNotFoundException;
import com.muskan.bookmyshowmuskan.exception.SeatNotAvailableException;
import com.muskan.bookmyshowmuskan.exception.TheatreNotFoundException;
import com.muskan.bookmyshowmuskan.exception.UserNotFoundException;
import com.muskan.bookmyshowmuskan.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MovieShowService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    TheatreService theatreService;



    public List<MovieShow> getAllMovieShow() {

        List<MovieShow> movieShows = movieShowRepository.findAll();
        return movieShows;
    }

    public MovieShow getMovieShowById(int id) {

        Optional<MovieShow> movieShow = movieShowRepository.findById(id);
        return movieShow.get();
    }


    public Ticket bookTicket(TicketPayload ticketPayload) {


        MovieShow movieShow = getMovieShowById(ticketPayload.getMovieShowId());
        Optional<User> user = userRepository.findById(ticketPayload.getUserId());
        logger.info("address of theatreService {}",theatreService);

        if(!user.isPresent()){
            logger.error("No user found with the userId Given {}",ticketPayload.getUserId());
            throw new UserNotFoundException("No user found with the userId Given-"+ticketPayload.getUserId());
        }
        List<Seat> collect = movieShow.getSeats().stream().filter(s ->
                (ticketPayload.getSeatList().contains(s.getSeatNumber())
                        && !s.isAvailable())).collect(Collectors.toList());


        if(collect.size()>0){
            logger.error("Requested Seat Not Available {}",collect);
            throw new SeatNotAvailableException("Requested Seat Not Available");

        }
        else {
            Ticket ticket = new Ticket();

            ticket.setMovieName(movieShow.getMovie().getTitle());
            ticket.setTheatreName(movieShow.getTheatre().getName());
            ticket.setScreenNumber(movieShow.getScreenNumber());
            ticket.setShowTime(movieShow.getShowTime());
            ticket.setUser(user.get());

            StringBuilder seatList  = new StringBuilder();
            Iterator<Integer> iter = ticketPayload.getSeatList().iterator();
            while(iter.hasNext())
            {
                seatList.append(iter.next());
                if(iter.hasNext()){
                    seatList.append(",");
                }
            }

            ticket.setSeatNumber(seatList.toString());

            movieShow.getSeats().stream()
                    .filter(s->(ticketPayload.getSeatList().contains(s.getSeatNumber())))
                    .forEach(seat -> {
                        seat.setAvailable(false);
                    });

            movieShowRepository.save(movieShow);
            return ticketRepository.save(ticket);
        }

    }

    public MovieShow addMovieShow(MovieShowPayload movieShowPayload) {

        MovieShow movieShow = new MovieShow();
        List<Seat> seats = new ArrayList<>();

        Optional<Movie> movie = movieRepository.findById(movieShowPayload.getMovieId());

        if(!movie.isPresent()){
            logger.error("No movie found with the given id:",movieShowPayload.getMovieId());
            throw new MovieNotFoundException("No movie found with the given id: "+movieShowPayload.getMovieId());
        }

        Optional<Theatre> theatre = theatreRepository.findById(movieShowPayload.getTheatreId());

        if(!theatre.isPresent()){
            logger.error("No theatre found with the given id:",movieShowPayload.getTheatreId());
            throw new TheatreNotFoundException("No theatre found with the given id: "+movieShowPayload.getTheatreId());
        }

        movieShow.setSeatcount(movieShowPayload.getSeatCount());
        movieShow.setScreenNumber(movieShowPayload.getScreenNumber());
        movieShow.setShowTime(movieShowPayload.getShowTime());
        movieShow.setMovie(movie.get());
        movieShow.setTheatre(theatre.get());

        IntStream.range(1,21).forEach(i->{
            seats.add(new Seat(i,Seat.SeatType.GOLD,true,movieShow));
        });
        IntStream.range(21,41).forEach(i->{
            seats.add(new Seat(i, Seat.SeatType.PLATINUM,true,movieShow));
        });

        movieShow.setSeats(seats);

        return movieShowRepository.save(movieShow);
    }
}
