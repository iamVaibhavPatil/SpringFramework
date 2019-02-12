package com.pharmachain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.pharmachain.domain.StoreUser;

import reactor.core.publisher.Mono;

@Repository
public interface StoreUserRepository extends ReactiveMongoRepository<StoreUser, Long> {

	Mono<StoreUser> findByUserNameIgnoreCase(String userName);
}
