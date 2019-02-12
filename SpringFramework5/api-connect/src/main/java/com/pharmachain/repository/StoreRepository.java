package com.pharmachain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.pharmachain.domain.Store;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StoreRepository extends ReactiveMongoRepository<Store, Long> {

	Mono<Store> findByStoreId(Long storeId);
	
	Mono<Store> deleteByStoreId(Long storeId);
	
	Flux<Store> findByStoreNameContainingIgnoreCase(String storeName);
}
