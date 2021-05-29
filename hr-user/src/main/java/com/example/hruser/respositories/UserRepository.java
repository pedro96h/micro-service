package com.example.hruser.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
}
