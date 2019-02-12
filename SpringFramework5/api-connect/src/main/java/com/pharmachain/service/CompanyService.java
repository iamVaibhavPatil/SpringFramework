package com.pharmachain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmachain.domain.Company;
import com.pharmachain.dto.CompanyDTO;
import com.pharmachain.exception.NotFoundException;
import com.pharmachain.mapper.CompanyMapper;
import com.pharmachain.repository.CompanyRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private SequenceService sequenceService;

	public Flux<CompanyDTO> getCompanies() {
		return companyRepository.findAll().map(company -> {
			return companyMapper.companyToCompanyDTO(company);
		});
	}
	
	@Transactional
	public Mono<CompanyDTO> addCompany(CompanyDTO companyDTO) {
		Company company = companyMapper.companyDTOToCompany(companyDTO);
		company.setCompanyId(sequenceService.getNextSequenceId(SequenceService.COMPANY_SEQ_KEY));
		Mono<Company> savedCompany = companyRepository.save(company);
		return savedCompany.flatMap(c -> {
			CompanyDTO cDTO = companyMapper.companyToCompanyDTO(c);
			return Mono.just(cDTO);
		});
	}

	@Transactional
	public Mono<CompanyDTO> updateCompany(Long companyId, CompanyDTO companyDTO) {
		return companyRepository.findByCompanyId(companyId).flatMap(company -> {
			if(companyDTO.getCompanyCode() != null) {
				company.setCompanyCode(companyDTO.getCompanyCode());
			}
			if(companyDTO.getCompanyName() != null) {
				company.setCompanyName(companyDTO.getCompanyName());
			}
			if(companyDTO.getExpiryReturnsAllowed() != null) {
				company.setExpiryReturnsAllowed(companyDTO.getExpiryReturnsAllowed());
			}
			if(companyDTO.getVerified() != null) {
				company.setVerified(companyDTO.getVerified());
			}
			return companyRepository.save(company).flatMap(c -> {
				CompanyDTO cDTO = companyMapper.companyToCompanyDTO(c);
				return Mono.just(cDTO);
			});
		}).switchIfEmpty(Mono.error(new NotFoundException("COMPANY NOT FOUND")));
	}
	
	public void deleteCompany(Long companyId) {
		companyRepository.deleteByCompanyId(companyId)
			.switchIfEmpty(Mono.error(new NotFoundException("COMPANY NOT FOUND")))
			.subscribe();
	}
	
	public Flux<CompanyDTO> findByCompanyCodeOrName(String companyCode, String companyName, Pageable pageable) {
		return companyRepository.findByCompanyCodeContainingAndCompanyNameContaining(companyCode, companyName, pageable)
				.map(company -> {
					return companyMapper.companyToCompanyDTO(company);
				});
	}
}
