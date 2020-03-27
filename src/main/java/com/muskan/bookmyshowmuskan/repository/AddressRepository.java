package com.muskan.bookmyshowmuskan.repository;

import com.muskan.bookmyshowmuskan.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
