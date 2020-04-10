package com.muskan.bookmyshowmuskan.bo;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;


@Data
public class UserSession {

    private String email;
    private boolean isLoggedIn = false;
}
