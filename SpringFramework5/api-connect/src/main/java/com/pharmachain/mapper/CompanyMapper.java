package com.pharmachain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pharmachain.domain.Company;
import com.pharmachain.dto.CompanyDTO;

@Mapper
public interface CompanyMapper {

	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	
	CompanyDTO companyToCompanyDTO(Company company);
	
	Company companyDTOToCompany(CompanyDTO companyDTO);
}
