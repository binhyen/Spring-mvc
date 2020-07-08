package com.laptrinhjava.spring.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjava.spring.dto.NewsDTO;
import com.laptrinhjava.spring.service.ICategoryService;
import com.laptrinhjava.spring.service.INewsService;
import com.laptrinhjava.spring.util.MessageUtils;

@Controller(value = "newControllerOfAdmin")
public class NewsController {
	
	@Autowired
	private INewsService newsService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private MessageUtils messageUtils;
	
	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpServletRequest request) {
		NewsDTO model = new NewsDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListModel(newsService.findAll(pageable));
		model.setTotalItem(newsService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem()/model.getLimit()));
		
		ModelAndView mav = new ModelAndView("admin/news/list");
		mav.addObject("model", model);
		String message = request.getParameter("message");
		if (message != null) {
			Map<String, String> messageResponse = messageUtils.getMessage(message);
			mav.addObject("messageResponse", messageResponse.get("messageResponse"));
			mav.addObject("alert", messageResponse.get("alert"));
		}
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNews(@RequestParam(value = "id", required = false) Long id,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/news/edit");
		NewsDTO model = new NewsDTO();
		if (id != null) {
			model = newsService.findById(id);
		}
		String message = request.getParameter("message");
		if (message != null) {
			Map<String, String> messageResponse = messageUtils.getMessage(message);
			mav.addObject("messageResponse", messageResponse.get("messageResponse"));
			mav.addObject("alert", messageResponse.get("alert"));
		}
		
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}
	
}
