package com.pharmachain.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.pharmachain.domain.Company;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

	Mono<Company> findByCompanyId(Long companyId);

	Mono<Company> deleteByCompanyId(Long companyId);

	Flux<Company> findByCompanyCodeContainingAndCompanyNameContaining(String companyCode, String companyName, Pageable pageable);
}
