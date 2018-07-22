package guru.springframework.rest.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import guru.springframework.rest.api.v1.model.CategoryDTO;
import guru.springframework.rest.domain.Category;

public class CategoryMapperTest {

	public static final String NAME = "Joe";
	public static final long ID = 1L;
	CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
	
	@Test
	public void categoryToCategoryDTO() throws Exception {
		
		//Given
		Category category = new Category();
		category.setId(ID);
		category.setName(NAME);
		
		//When
		CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
		
		//Then
		assertEquals(Long.valueOf(ID), categoryDTO.getId());
		assertEquals(NAME, categoryDTO.getName());
	}
	
}
