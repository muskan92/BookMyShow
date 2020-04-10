package com.muskan.bookmyshowmuskan.exception;

import com.muskan.bookmyshowmuskan.entity.Theatre;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TheatreNotFoundException extends RuntimeException {

    public TheatreNotFoundException(String message){
        super(message);
    }
}
