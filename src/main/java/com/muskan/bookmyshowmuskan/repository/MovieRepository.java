package com.muskan.bookmyshowmuskan.repository;

import com.muskan.bookmyshowmuskan.entity.Movie;
import com.muskan.bookmyshowmuskan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {


    Optional<Movie> findByTitle(String title);

}
