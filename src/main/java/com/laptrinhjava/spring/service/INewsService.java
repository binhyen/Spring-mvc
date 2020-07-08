package com.laptrinhjava.spring.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjava.spring.dto.NewsDTO;

public interface INewsService {
	
	List<NewsDTO> findAll(Pageable pageable);

	Integer getTotalItem();
	
	NewsDTO findById(long id);
	
	NewsDTO insert(NewsDTO insertDTO);
	
	NewsDTO update(NewsDTO updateDTO);
	
	NewsDTO save(NewsDTO dto);

	void delete(long[] ids);
}
