package com.laptrinhjava.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjava.spring.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUserNameAndStatus(String name, Integer status);
}
