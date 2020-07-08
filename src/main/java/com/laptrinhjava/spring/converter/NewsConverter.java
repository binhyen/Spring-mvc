package com.laptrinhjava.spring.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjava.spring.dto.NewsDTO;
import com.laptrinhjava.spring.entity.NewsEntity;

@Component
public class NewsConverter {
	public NewsDTO toDto(NewsEntity newsEntity) {
		NewsDTO result = new NewsDTO();
		result.setId(newsEntity.getId());
		result.setTitle(newsEntity.getTitle());
		result.setShortDescription(newsEntity.getShortDescription());
		result.setContent(newsEntity.getContent());
		result.setThumbnail(newsEntity.getThumbnail());
		result.setCategoryCode(newsEntity.getCategory().getCode());
		return result;
	}
	
	public NewsEntity toEntity(NewsDTO newsDTO) {
		NewsEntity result = new NewsEntity();
		result.setTitle(newsDTO.getTitle());
		result.setShortDescription(newsDTO.getShortDescription());
		result.setContent(newsDTO.getContent());
		result.setThumbnail(newsDTO.getThumbnail());
		return result;
	}
	
	public NewsEntity toEntity(NewsEntity oldEntity,NewsDTO newsDTO) {
		oldEntity.setTitle(newsDTO.getTitle());
		oldEntity.setShortDescription(newsDTO.getShortDescription());
		oldEntity.setContent(newsDTO.getContent());
		oldEntity.setThumbnail(newsDTO.getThumbnail());
		return oldEntity;
	}
}
