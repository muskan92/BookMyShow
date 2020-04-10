package com.muskan.bookmyshowmuskan.controller;

import com.muskan.bookmyshowmuskan.bo.TheatrePayload;
import com.muskan.bookmyshowmuskan.entity.Theatre;
import com.muskan.bookmyshowmuskan.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThetreController {

    @Autowired
    private TheatreService theatreService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Theatre> addTheatre(@RequestBody TheatrePayload theatre){

        Theatre theatre1 = theatreService.addTheatre(theatre);
        return new ResponseEntity<>(theatre1, HttpStatus.OK);
    }
}
