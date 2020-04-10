package com.muskan.bookmyshowmuskan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.IM_USED)
public class TheatreAlreadyExistException extends RuntimeException {

    public TheatreAlreadyExistException(String message){

        super(message);
    }
}
