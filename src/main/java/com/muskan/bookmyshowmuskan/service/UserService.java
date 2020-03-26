package com.muskan.bookmyshowmuskan.service;

import com.muskan.bookmyshowmuskan.bo.Address;
import com.muskan.bookmyshowmuskan.bo.LoginUser;
import com.muskan.bookmyshowmuskan.bo.User;
import com.muskan.bookmyshowmuskan.exception.AccountAlreadyExistException;
import com.muskan.bookmyshowmuskan.repository.AddressRepository;
import com.muskan.bookmyshowmuskan.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;


    public String addUser(User entity) {
        Optional<User> optionalUser = userRepository.findByEmail(entity.getEmail());
        HttpStatus httpStatus;
        if (optionalUser.isPresent()) {
            return "Account already exist with email : "+entity.getEmail();
        }else{
            logger.info("Adding new user");
            userRepository.save(entity);
            return "Account created.";
        }

    }


    public User updateUser(User entity) {

        Optional<User> optionalUser = userRepository.findByEmail(entity.getEmail());
            User savedUser = null;
        if (optionalUser.isPresent()) {

            logger.info("updating user details");

            optionalUser.get().getUserAddress().setBuilding(entity.getUserAddress().getBuilding());
            optionalUser.get().getUserAddress().setArea(entity.getUserAddress().getArea());
            optionalUser.get().getUserAddress().setPin(entity.getUserAddress().getPin());

            addressRepository.save(optionalUser.get().getUserAddress());

            optionalUser.get().setEmail(entity.getEmail());
            optionalUser.get().setPassword(entity.getPassword());
            savedUser = userRepository.save(optionalUser.get());

        }
            return savedUser;
    }

    public HttpStatus loginUser(LoginUser loginUser) {
        Optional<User> optionalUser = userRepository.findByEmail(loginUser.getEmail());
        if (optionalUser.isPresent() && loginUser.getPassword().equals(optionalUser.get().getPassword())) {

            return HttpStatus.OK;
        } else {
            return HttpStatus.UNAUTHORIZED;
        }
    }

}
