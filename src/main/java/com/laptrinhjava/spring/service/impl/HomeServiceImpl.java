package com.laptrinhjava.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.laptrinhjava.spring.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Override
	public List<String> loadMenu() {
		List<String> menu = new ArrayList<>();
		menu.add("Home");
		menu.add("Lập trình java");
		menu.add("Liên hệ");
		menu.add("Thanh toán");
		return menu;
	}

}
