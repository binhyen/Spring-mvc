package com.laptrinhjava.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjava.spring.dto.NewsDTO;
import com.laptrinhjava.spring.entity.NewsEntity;
import com.laptrinhjava.spring.repository.NewsRepository;
import com.laptrinhjava.spring.service.INewsService;

@Service
public class NewsService implements INewsService {

//	@Autowired
//	private INewsDAO newsDAO;
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> models = new ArrayList<>();
		List<NewsEntity> newsEntity = newsRepository.findAll(pageable).getContent(); 
		for (NewsEntity item : newsEntity) {
			NewsDTO newsDTO = new NewsDTO();
			newsDTO.setTitle(item.getTitle());
			newsDTO.setShortDescription(item.getShortDescription());
			models.add(newsDTO);
		}
		return models;
	}

	@Override
	public Integer getTotalItem() {
		return (int) newsRepository.count();
	}
	
}
