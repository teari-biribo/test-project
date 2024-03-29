package com.web.evm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.evm.entity.UserEntity;


public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	UserEntity findByUsername(String username);
	Boolean existsByUsername(String username);
	
}
