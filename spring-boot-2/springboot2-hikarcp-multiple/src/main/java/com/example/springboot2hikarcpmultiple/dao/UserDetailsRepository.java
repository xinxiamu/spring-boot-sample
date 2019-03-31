package com.example.springboot2hikarcpmultiple.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
	
	List<UserDetails> findByUser(User user);  
	
	List<UserDetails> findByUserId(Long userId);

}
