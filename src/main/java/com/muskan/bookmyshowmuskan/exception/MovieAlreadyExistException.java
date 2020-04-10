package com.muskan.bookmyshowmuskan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.IM_USED)
public class MovieAlreadyExistException extends RuntimeException {

    public MovieAlreadyExistException(String message){

        super(message);
    }
}
