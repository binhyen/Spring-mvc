package com.laptrinhjava.spring.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjava.spring.dao.INewsDAO;
import com.laptrinhjava.spring.mapper.NewsMapper;
import com.laptrinhjava.spring.model.NewsModel;

@Repository
public class NewsDAO extends AbsTractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return query(sql.toString(), new NewsMapper());
	}

}
