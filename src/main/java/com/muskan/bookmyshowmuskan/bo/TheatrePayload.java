package com.muskan.bookmyshowmuskan.bo;

import lombok.Data;

@Data
public class TheatrePayload {

    String name;

    float rating;

    int ownerId;

    int addressId;

}
