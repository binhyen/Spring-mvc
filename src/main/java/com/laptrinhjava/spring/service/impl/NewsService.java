package com.laptrinhjava.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjava.spring.converter.NewsConverter;
import com.laptrinhjava.spring.dto.NewsDTO;
import com.laptrinhjava.spring.entity.CategoryEntity;
import com.laptrinhjava.spring.entity.NewsEntity;
import com.laptrinhjava.spring.repository.CategoryRepository;
import com.laptrinhjava.spring.repository.NewsRepository;
import com.laptrinhjava.spring.service.INewsService;

@Service
public class NewsService implements INewsService {

	@Autowired
    private NewsConverter newsConverter;
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> models = new ArrayList<>();
		List<NewsEntity> newsEntity = newsRepository.findAll(pageable).getContent(); 
		for (NewsEntity item : newsEntity) {
			NewsDTO newsDTO = newsConverter.toDto(item);
			models.add(newsDTO);
		}
		return models;
	}

	@Override
	public Integer getTotalItem() {
		return (int) newsRepository.count();
	}

	@Override
	public NewsDTO findById(long id) {
		return newsConverter.toDto(newsRepository.findOne(id));
	}

	@Override
	@Transactional
	public NewsDTO insert(NewsDTO insertDTO) {
		CategoryEntity category = categoryRepository.findOneByCode(insertDTO.getCategoryCode());
		NewsEntity newsEntity = newsConverter.toEntity(insertDTO);
		newsEntity.setCategory(category);
		return newsConverter.toDto(newsRepository.save(newsEntity));
	}

	@Override
	@Transactional
	public NewsDTO update(NewsDTO updateDTO) {
		NewsEntity oldEntity = newsRepository.findOne(updateDTO.getId());
		CategoryEntity category = categoryRepository.findOneByCode(updateDTO.getCategoryCode());
		oldEntity.setCategory(category);
		NewsEntity updateEntity = newsConverter.toEntity(oldEntity, updateDTO);
		return newsConverter.toDto(newsRepository.save(updateEntity));
	}

	@Override
	@Transactional
	public NewsDTO save(NewsDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewsEntity newsEntity = new NewsEntity();
		if (dto.getId() != null) {
			NewsEntity oldEntity = newsRepository.findOne(dto.getId());
			oldEntity.setCategory(category);
			newsEntity = newsConverter.toEntity(oldEntity, dto);
		} else {
			newsEntity = newsConverter.toEntity(dto);
			newsEntity.setCategory(category);
		}
		return newsConverter.toDto(newsRepository.save(newsEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			newsRepository.delete(id);
		}
	}
}
