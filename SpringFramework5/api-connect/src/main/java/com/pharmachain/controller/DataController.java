package com.pharmachain.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pharmachain.dto.CountryDTO;
import com.pharmachain.dto.RegionDTO;
import com.pharmachain.dto.StateDTO;
import com.pharmachain.dto.StoreTypeDTO;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/data")
public class DataController {

	@GetMapping("/countries")
	@ResponseStatus(HttpStatus.OK)
	public Flux<CountryDTO> getCountries() {
		List<CountryDTO> countries = new LinkedList<CountryDTO>();
		countries.add(new CountryDTO("IN", "INDIA"));
		return Flux.fromIterable(countries);
	}
	
	@GetMapping("/states")
	@ResponseStatus(HttpStatus.OK)
	public Flux<StateDTO> getStates() {
		List<StateDTO> states = new LinkedList<StateDTO>();
		states.add(new StateDTO("GJ", "GUJARAT"));
		states.add(new StateDTO("MH", "MAHARASHTRA"));
		states.add(new StateDTO("MP", "MADHYA PRADESH"));
		return Flux.fromIterable(states);
	}
	
	@GetMapping("/regions")
	@ResponseStatus(HttpStatus.OK)
	public Flux<RegionDTO> getRegions() {
		List<RegionDTO> regions = new LinkedList<RegionDTO>();
		regions.add(new RegionDTO("JALG", "JALGAON"));
		regions.add(new RegionDTO("MUMB", "MUMBAI"));
		regions.add(new RegionDTO("PUNE", "PUNE"));
		regions.add(new RegionDTO("VAPI", "VAPI"));
		return Flux.fromIterable(regions);
	}
	
	@GetMapping("/storetypes")
	@ResponseStatus(HttpStatus.OK)
	public Flux<StoreTypeDTO> getStoreTypes() {
		List<StoreTypeDTO> types = new LinkedList<StoreTypeDTO>();
		types.add(new StoreTypeDTO("RETAIL", "RETAIL"));
		types.add(new StoreTypeDTO("WHOLESALE", "WHOLESALE"));
		return Flux.fromIterable(types);
	}
}
