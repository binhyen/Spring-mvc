package com.laptrinhjava.spring.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjava.spring.converter.CategoryConverter;
import com.laptrinhjava.spring.dto.CategoryDTO;
import com.laptrinhjava.spring.entity.CategoryEntity;
import com.laptrinhjava.spring.repository.CategoryRepository;
import com.laptrinhjava.spring.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
    private CategoryConverter categoryConverter;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item : entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}
	
	
}
