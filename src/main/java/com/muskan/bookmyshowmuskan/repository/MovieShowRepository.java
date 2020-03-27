package com.muskan.bookmyshowmuskan.repository;

import com.muskan.bookmyshowmuskan.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {
}
