package com.laptrinhjava.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjava.spring.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Long>{

}
