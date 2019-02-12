package com.pharmachain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.pharmachain.domain.StoreUser;
import com.pharmachain.dto.StoreUserDTO;

@Mapper
public interface StoreUserMapper {

	StoreUserMapper INSTANCE = Mappers.getMapper(StoreUserMapper.class);
	
	@Mapping(target="password", ignore=true)
	StoreUserDTO storeUserToStoreUserDTO(StoreUser storeUser);
	
	StoreUser storeUserDTOToStoreUser(StoreUserDTO storeUserDTO);
}
