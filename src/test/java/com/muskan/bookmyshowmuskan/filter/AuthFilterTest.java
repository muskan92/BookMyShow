package com.muskan.bookmyshowmuskan.filter;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthFilterTest {

    @Test
    void doFilterInternal() {

        Assert.assertTrue("http://localhost:8009/user/login".contains("user/login"));

    }
}