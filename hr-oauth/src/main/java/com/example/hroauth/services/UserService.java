package com.example.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hroauth.entities.User;
import com.example.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	public User findByEmail(String email) {
		User user = userFeignClient.findById(email).getBody();
		if (user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: " + email);
		return user;
	}
}
