package com.muskan.bookmyshowmuskan.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.IM_USED, reason = "Account already exist with the given emailId")
public class AccountAlreadyExistException extends RuntimeException {

    public AccountAlreadyExistException(String message){
        super(message);
    }
}
