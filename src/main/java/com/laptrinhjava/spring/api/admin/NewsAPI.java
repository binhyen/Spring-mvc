package com.laptrinhjava.spring.api.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjava.spring.converter.NewsConverter;
import com.laptrinhjava.spring.dto.NewsDTO;
import com.laptrinhjava.spring.entity.NewsEntity;
import com.laptrinhjava.spring.repository.NewsRepository;
import com.laptrinhjava.spring.service.INewsService;

@RestController(value = "newsAPIOfAdmin")
public class NewsAPI {
	
	@Autowired
	private INewsService newsService;
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private NewsConverter newsConverter;
	
	@GetMapping(value = "/api/news")
	public List<NewsDTO> getNews() {
		List<NewsDTO> list = new ArrayList<NewsDTO>();
		List<NewsEntity> listEntity = newsRepository.findAll();
		for (NewsEntity newsEntity : listEntity) {
			list.add(newsConverter.toDto(newsEntity));
		}
		return list;
	}
	
	@PostMapping(value = "/api/news")
	public NewsDTO createNews(@RequestBody NewsDTO newDTO) {
		return newsService.save(newDTO);
	}
	
	@PutMapping(value = "/api/news")
	public NewsDTO updateNews(@RequestBody NewsDTO newDTO) {
		return newsService.save(newDTO);
	}
	
	@DeleteMapping(value = "/api/news")
	public void deleteNews(@RequestBody long[] ids) {
		System.out.println("ids"+ids.toString());
		newsService.delete(ids);
	}
}
