package com.laptrinhjava.spring.mapper;

import java.sql.ResultSet;

import com.laptrinhjava.spring.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		CategoryModel category = new CategoryModel();
		try {
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			category.setCode(rs.getString("code"));
			return category;
		} catch (Exception e) {
			return null;
		}
	}
}
