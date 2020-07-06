package com.laptrinhjava.spring.dao.impl;

import java.util.List;

import com.laptrinhjava.spring.dao.ICategoryDAO;
import com.laptrinhjava.spring.mapper.CategoryMapper;
import com.laptrinhjava.spring.model.CategoryModel;

public class CategoryDAO extends AbsTractDAO<CategoryModel> implements ICategoryDAO {
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> categories = query(sql, new CategoryMapper(), id);
		return categories.isEmpty() ? null : categories.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> categories = query(sql, new CategoryMapper(), code);
		return categories.isEmpty() ? null : categories.get(0);
	}
	
}
