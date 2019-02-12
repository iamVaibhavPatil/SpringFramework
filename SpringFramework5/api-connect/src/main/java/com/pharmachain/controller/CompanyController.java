package com.pharmachain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pharmachain.dto.CompanyDTO;
import com.pharmachain.service.CompanyService;
import com.pharmachain.util.PageUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

	private final CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Flux<CompanyDTO> getCompanies() {
		return companyService.getCompanies();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Mono<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDTO) {
		return companyService.addCompany(companyDTO);
	}

	@PutMapping({"/{companyId}"})
	@ResponseStatus(HttpStatus.OK)
	public Mono<CompanyDTO> updateCompany(@PathVariable Long companyId, @RequestBody CompanyDTO companyDTO) {
		return companyService.updateCompany(companyId, companyDTO);
	}

	@DeleteMapping({"/{companyId}"})
	@ResponseStatus(HttpStatus.OK)
	public void deleteCompany(@PathVariable Long companyId) {
		companyService.deleteCompany(companyId);
	}
	
	@GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
	public Flux<CompanyDTO> findByCompanyCodeOrName(@RequestParam(required = true, value = "q") String q,
			@RequestParam(required = false, name = "pageNumber") Integer pageNumber,
			@RequestParam(required = false, name = "pageSize") Integer pageSize) {
		return companyService.findByCompanyCodeOrName(q, q, PageUtils.getPageable(pageNumber, pageSize));
	}
}
