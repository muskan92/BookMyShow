package com.muskan.bookmyshowmuskan.filter;

import com.muskan.bookmyshowmuskan.bo.UserSession;
import com.muskan.bookmyshowmuskan.exception.UserNotAuthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class AuthFilter extends OncePerRequestFilter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserSession userSession;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        logger.info("starting urlRequest{} method{}", httpServletRequest.getRequestURL(), httpServletRequest.getMethod());

        if(!userSession.isLoggedIn() && !httpServletRequest.getRequestURL().toString().contains("user/login")){
            throw new UserNotAuthorizedException("user is not logged in");
        }


        filterChain.doFilter(httpServletRequest, httpServletResponse);
        logger.info("Logging Response :{}", httpServletResponse.getContentType());
    }

}
