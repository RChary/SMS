package com.school.repository;

import com.school.dao.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository  extends MongoRepository<Address, Long> {

    Address findById(long id);
    List<Address> findAll();
}
