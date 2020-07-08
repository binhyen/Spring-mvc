package com.laptrinhjava.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjava.spring.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String code);
}
