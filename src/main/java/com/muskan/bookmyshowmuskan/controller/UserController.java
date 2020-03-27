package com.muskan.bookmyshowmuskan.controller;

import com.muskan.bookmyshowmuskan.bo.LoginUser;
import com.muskan.bookmyshowmuskan.entity.User;
import com.muskan.bookmyshowmuskan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User user)  {
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);

        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/getmsg", method = RequestMethod.GET)
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<>("helloworld", HttpStatus.OK);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> userLogin(@RequestBody LoginUser loginUser){

        return new ResponseEntity<>(userService.loginUser(loginUser));
    }


    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser()  {
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }


}
