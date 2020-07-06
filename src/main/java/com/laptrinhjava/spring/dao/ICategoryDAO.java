package com.laptrinhjava.spring.dao;

import java.util.List;

import com.laptrinhjava.spring.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
//	public Connection getConnection();
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String code);
}
