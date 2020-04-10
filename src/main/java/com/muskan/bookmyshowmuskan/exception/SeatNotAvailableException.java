package com.muskan.bookmyshowmuskan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Requested seat/s not available while booking ticket")
public class SeatNotAvailableException extends RuntimeException {

    public SeatNotAvailableException(String message) {
        super(message);
    }
}
