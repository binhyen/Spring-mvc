package com.laptrinhjava.spring.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjava.spring.converter.NewsConverter;
import com.laptrinhjava.spring.dto.NewsDTO;
import com.laptrinhjava.spring.entity.NewsEntity;
import com.laptrinhjava.spring.repository.NewsRepository;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private NewsConverter newsConverter;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<NewsDTO> list = new ArrayList<NewsDTO>();
		List<NewsEntity> listEntity = newsRepository.findAll();
		for (NewsEntity newsEntity : listEntity) {
			list.add(newsConverter.toDto(newsEntity));
		}
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("model", list);
		return mav;
	}
	
//	@GetMapping(value = "/api/news")
//	public List<NewsDTO> getNews() {
//		List<NewsDTO> list = new ArrayList<NewsDTO>();
//		List<NewsEntity> listEntity = newsRepository.findAll();
//		for (NewsEntity newsEntity : listEntity) {
//			list.add(newsConverter.toDto(newsEntity));
//		}
//		return list;
//	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// same removeSession
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
