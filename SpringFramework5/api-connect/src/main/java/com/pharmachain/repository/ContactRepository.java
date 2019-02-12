package com.pharmachain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.pharmachain.domain.Contact;

@Repository
public interface ContactRepository extends ReactiveMongoRepository<Contact, Long>{

}
