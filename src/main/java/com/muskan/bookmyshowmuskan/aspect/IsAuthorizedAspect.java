package com.muskan.bookmyshowmuskan.aspect;

import com.muskan.bookmyshowmuskan.bo.UserSession;
import com.muskan.bookmyshowmuskan.exception.UserNotAuthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IsAuthorizedAspect {

    @Autowired
    private UserSession userSession;

    private static Logger logger = LoggerFactory.getLogger(Logger.class);

    @Around("execution(* *(..)) && @annotation(com.muskan.bookmyshowmuskan.annotation.IsAuthorized)")
    public Object authorize(ProceedingJoinPoint point) throws Throwable {

        if(!userSession.isLoggedIn()){
            throw new UserNotAuthorizedException("user is not logged in");
        }

        return null;
    }
}
