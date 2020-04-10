package com.muskan.bookmyshowmuskan.repository;

import com.muskan.bookmyshowmuskan.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
