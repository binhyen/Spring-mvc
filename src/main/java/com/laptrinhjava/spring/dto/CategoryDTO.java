package com.laptrinhjava.spring.dto;

public class CategoryDTO extends AbstractDTO<CategoryDTO>{
	private String name;
	private String code;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
