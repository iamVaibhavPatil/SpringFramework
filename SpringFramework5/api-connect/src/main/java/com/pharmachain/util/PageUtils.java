package com.pharmachain.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageUtils {

	public static Pageable getPageable(Integer pageNumber, Integer pageSize) {
		if(pageNumber == null || pageSize == null) {
			return PageRequest.of(0, 60);
		}
		return PageRequest.of(pageNumber, pageSize, new Sort(Sort.Direction.DESC, "createdDate"));
	}
}
