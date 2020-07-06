package com.laptrinhjava.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjava.spring.constant.SystemConstant;
import com.laptrinhjava.spring.dto.MyUser;
import com.laptrinhjava.spring.entity.RoleEntity;
import com.laptrinhjava.spring.entity.UserEntity;
import com.laptrinhjava.spring.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity  userEntity= userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		List<GrantedAuthority> authorities= new ArrayList<>();
		for (RoleEntity role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		//put rhong tin vao security duy trì thong tin
		MyUser myUser = new MyUser(userEntity.getFullName(), userEntity.getPassword(), 
				true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
