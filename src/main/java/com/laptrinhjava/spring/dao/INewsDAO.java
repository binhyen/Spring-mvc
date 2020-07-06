package com.laptrinhjava.spring.dao;

import java.util.List;

import com.laptrinhjava.spring.model.NewsModel;

public interface INewsDAO extends GenericDAO<NewsModel> {

	List<NewsModel> findAll();

}
