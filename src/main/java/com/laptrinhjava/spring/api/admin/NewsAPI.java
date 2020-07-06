package com.laptrinhjava.spring.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjava.spring.dto.NewsDTO;

@RestController(value = "newsAPIOfAdmin")
public class NewsAPI {
	
	@GetMapping(value = "/api/news")
	public NewsDTO getNews(@RequestBody NewsDTO newDTO) {
		return newDTO;
	}
	
	@PostMapping(value = "/api/news")
	public NewsDTO createNews(@RequestBody NewsDTO newDTO) {
		return newDTO;
	}
	
	@PutMapping(value = "/api/news")
	public NewsDTO updateNews(@RequestBody NewsDTO newDTO) {
		return newDTO;
	}
	
	@DeleteMapping(value = "/api/news")
	public void deleteNews(@RequestBody long[] ids) {
		System.out.println("ids"+ids.toString());
	}
}
