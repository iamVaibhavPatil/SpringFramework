package com.pharmachain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pharmachain.domain.ProspectStore;
import com.pharmachain.dto.ProspectStoreDTO;

@Mapper
public interface ProspectStoreMapper {

	ProspectStoreMapper INSTANCE = Mappers.getMapper(ProspectStoreMapper.class);
	
	ProspectStoreDTO prospectToProspectDTO(ProspectStore prospectStore);
	
	ProspectStore prospectDTOToProspect(ProspectStoreDTO prospectStoreDTO);
}
