package com.pharmachain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.pharmachain.domain.Address;

@Repository
public interface AddressRepository extends ReactiveMongoRepository<Address, Long>{

}
