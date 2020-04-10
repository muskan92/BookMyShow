package com.muskan.bookmyshowmuskan.bo;

import com.muskan.bookmyshowmuskan.entity.Seat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MovieShowPayload {

    Date showTime;
    Integer seatCount;
    Integer theatreId;
    Integer movieId;
    Integer screenNumber;
    List<Seat> seats;

}
