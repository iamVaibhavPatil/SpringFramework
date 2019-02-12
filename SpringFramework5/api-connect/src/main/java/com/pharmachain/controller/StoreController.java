package com.pharmachain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.pharmachain.dto.StoreDTO;
import com.pharmachain.service.StoreService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

	private final StoreService storeService;
	
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@GetMapping({"/{storeId}"})
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Mono<StoreDTO> getStore(@PathVariable Long storeId) {
		return storeService.getStore(storeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Mono<StoreDTO> addStore(@RequestBody StoreDTO storeDTO) {
		return storeService.addStore(storeDTO);
	}
	
	@PutMapping({"/{storeId}"})
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Mono<StoreDTO> updateStore(@PathVariable Long storeId, @RequestBody StoreDTO storeDTO) {
		return storeService.updateStore(storeId, storeDTO);
	}
	
	@DeleteMapping({"/{storeId}"})
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('ADMIN')")
	public Mono<ResponseEntity<?>> deleteStore(@PathVariable Long storeId) {
		storeService.deleteStore(storeId);
		return Mono.just(ResponseEntity.status(HttpStatus.OK).body("Store Deleted Successfully"));
	}
	
	@GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Flux<StoreDTO> search(@RequestParam(required = true, value = "q") String q) {
		return storeService.search(q);
	}
}
