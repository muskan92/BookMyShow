package com.muskan.bookmyshowmuskan.service;


import com.muskan.bookmyshowmuskan.bo.TheatrePayload;
import com.muskan.bookmyshowmuskan.entity.Address;
import com.muskan.bookmyshowmuskan.entity.Owner;
import com.muskan.bookmyshowmuskan.entity.Theatre;
import com.muskan.bookmyshowmuskan.exception.AddressNotFoundException;
import com.muskan.bookmyshowmuskan.exception.OwnerNotFoundException;
import com.muskan.bookmyshowmuskan.exception.TheatreAlreadyExistException;
import com.muskan.bookmyshowmuskan.repository.AddressRepository;
import com.muskan.bookmyshowmuskan.repository.OwnerRepository;
import com.muskan.bookmyshowmuskan.repository.TheatreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Scope(value = "prototype")
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class TheatreService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public Theatre addTheatre(TheatrePayload theatrePayload) {

        Theatre theatre = new Theatre();

        Optional<Theatre> optionalTheatre = theatreRepository.findByName(theatrePayload.getName());

        if(optionalTheatre.isPresent() && optionalTheatre.get().getAddress().getId() == theatrePayload.getAddressId()){
            logger.error("Theatre already exist with the name and address: "+theatrePayload.getName()+" "+theatrePayload.getAddressId());
            throw new TheatreAlreadyExistException("Theatre already exist with the name and address: "+theatrePayload.getName()+" "+theatrePayload.getAddressId());
        }

        Optional<Address> addressOptional = addressRepository.findById(theatrePayload.getAddressId());

        if(!addressOptional.isPresent()){

            logger.error("Address not found with the Id: "+theatrePayload.getAddressId());
            throw new AddressNotFoundException("Address not found with the Id: "+theatrePayload.getAddressId());
        }

        Optional<Owner> optionalOwner = ownerRepository.findById(theatrePayload.getOwnerId());

        if(!optionalOwner.isPresent()){

            logger.error("Owner not found with the Id: "+theatrePayload.getOwnerId());
            throw new OwnerNotFoundException("Owner not found with the Id: "+theatrePayload.getOwnerId());
        }

        else{
            theatre.setRating(theatrePayload.getRating());
            theatre.setName(theatrePayload.getName());
            theatre.setAddress(addressOptional.get());
            theatre.setOwner(optionalOwner.get());
            return theatreRepository.save(theatre);
        }

    }
}
