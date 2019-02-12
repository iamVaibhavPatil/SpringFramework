package com.pharmachain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pharmachain.domain.Store;
import com.pharmachain.dto.StoreDTO;

@Mapper
public interface StoreMapper {

	StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
	
	StoreDTO storeToStoreDTO(Store store);
	
	Store storeDTOToStore(StoreDTO storeDTO);
}
