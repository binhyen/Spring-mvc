package com.laptrinhjava.spring.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjava.spring.dto.CategoryDTO;
import com.laptrinhjava.spring.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDto(CategoryEntity categoryEntity) {
		CategoryDTO result = new CategoryDTO();
		result.setName(categoryEntity.getName());
		result.setCode(categoryEntity.getCode());
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO categoryDTO) {
		CategoryEntity result = new CategoryEntity();
		result.setName(categoryDTO.getName());
		result.setCode(categoryDTO.getCode());
		return result;
	}
}
