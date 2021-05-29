package com.example.hroauth.resources;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hroauth.entities.User;
import com.example.hroauth.services.UserService;

@Resource
@RestController
@RequestMapping(value = "/api/users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		try {
			User user = userService.findByEmail(email);
			return ResponseEntity.ok().body(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
}
