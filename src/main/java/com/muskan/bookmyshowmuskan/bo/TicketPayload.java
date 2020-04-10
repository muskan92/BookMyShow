package com.muskan.bookmyshowmuskan.bo;

import lombok.Data;

import java.util.List;

@Data
public class TicketPayload {

    int movieShowId;
    List<Integer> seatList;
    int userId;
}
