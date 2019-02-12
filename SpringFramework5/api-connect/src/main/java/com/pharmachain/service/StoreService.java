package com.pharmachain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmachain.domain.Store;
import com.pharmachain.dto.AddressDTO;
import com.pharmachain.dto.CreditInfoDTO;
import com.pharmachain.dto.LicenseInfoDTO;
import com.pharmachain.dto.StoreDTO;
import com.pharmachain.dto.TaxInfoDTO;
import com.pharmachain.exception.NotFoundException;
import com.pharmachain.mapper.StoreMapper;
import com.pharmachain.repository.StoreRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreMapper storeMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	public Mono<StoreDTO> getStore(Long storeId) {
		return storeRepository.findByStoreId(storeId).map(store -> {
			return storeMapper.storeToStoreDTO(store);
		}).switchIfEmpty(Mono.error(new NotFoundException("STORE NOT FOUND")));
	}
	
	public Flux<StoreDTO> search(String storeName) {
		return storeRepository.findByStoreNameContainingIgnoreCase(storeName)
							  .map(store -> {
								  return storeMapper.storeToStoreDTO(store);
							  }).switchIfEmpty(Mono.error(new NotFoundException("STORE NOT FOUND")));
	}
	
	@Transactional
	public Mono<StoreDTO> addStore(StoreDTO storeDTO) {
		Store store = storeMapper.storeDTOToStore(storeDTO);
		store.setStoreId(sequenceService.getNextSequenceId(SequenceService.STORE_SEQ_KEY));
		Mono<Store> savedStore = storeRepository.save(store);
		return savedStore.flatMap(s -> {
			StoreDTO sDTO = storeMapper.storeToStoreDTO(s);
			return Mono.just(sDTO);
		});
	}

	public Mono<StoreDTO> updateStore(Long storeId, StoreDTO storeDTO) {
		return storeRepository.findByStoreId(storeId).flatMap(store -> {
			
			// Start -- Map the Updated Store
			store.setStoreType(storeDTO.getStoreType());
			store.setStoreRegion(storeDTO.getStoreRegion());
			store.setStoreName(storeDTO.getStoreName());
			store.setFirstName(storeDTO.getFirstName());
			store.setLastName(storeDTO.getLastName());
			store.setEmail(storeDTO.getEmail());
			store.setMobileNumber(storeDTO.getMobileNumber());
			if(storeDTO.getAddress() != null) {
				AddressDTO addressDTO = storeDTO.getAddress();
				store.getAddress().setType(addressDTO.getType());
				store.getAddress().setAddressLine1(addressDTO.getAddressLine1());
				store.getAddress().setAddressLine2(addressDTO.getAddressLine2());
				store.getAddress().setCity(addressDTO.getCity());
				store.getAddress().setState(addressDTO.getState());
				store.getAddress().setPostalCode(addressDTO.getPostalCode());
				store.getAddress().setCountry(addressDTO.getCountry());
			}
			if(storeDTO.getTaxInfo() != null) {
				TaxInfoDTO taxInfoDTO = storeDTO.getTaxInfo();
				store.getTaxInfo().setGstNumber(taxInfoDTO.getGstNumber());
				store.getTaxInfo().setPanNumber(taxInfoDTO.getPanNumber());
				store.getTaxInfo().setVatNumber(taxInfoDTO.getVatNumber());
			}
			if(storeDTO.getLicenseInfo() != null) {
				LicenseInfoDTO licenseInfoDTO = storeDTO.getLicenseInfo();
				store.getLicenseInfo().setLicenseNumber(licenseInfoDTO.getLicenseNumber());
				store.getLicenseInfo().setIssueDate(licenseInfoDTO.getIssueDate());
				store.getLicenseInfo().setExpiryDate(licenseInfoDTO.getExpiryDate());
				store.getLicenseInfo().setImageUrl(licenseInfoDTO.getImageUrl());
			}
			if(storeDTO.getCreditInfo() != null) {
				CreditInfoDTO creditInfoDTO = storeDTO.getCreditInfo();
				store.getCreditInfo().setCreditPeriod(creditInfoDTO.getCreditPeriod());
				store.getCreditInfo().setDiscountBefore(creditInfoDTO.getDiscountBefore());
				store.getCreditInfo().setDiscountAfter(creditInfoDTO.getDiscountAfter());
				store.getCreditInfo().setBillingAmountLimit(creditInfoDTO.getBillingAmountLimit());
				store.getCreditInfo().setOrderAmountLimit(creditInfoDTO.getOrderAmountLimit());
			}
			store.setVerified(storeDTO.getVerified());
			store.setStatus(storeDTO.getStatus());
			// End -- Map the Updated Store
			
			// Update the Store
			return storeRepository.save(store).flatMap(s -> {
				StoreDTO sDTO = storeMapper.storeToStoreDTO(s);
				return Mono.just(sDTO);
			});
		}).switchIfEmpty(Mono.error(new NotFoundException("STORE NOT FOUND")));
	}

	public void deleteStore(Long storeId) {
		storeRepository.deleteByStoreId(storeId)
					   .switchIfEmpty(Mono.error(new NotFoundException("STORE NOT FOUND")))
					   .subscribe();
	}
}
