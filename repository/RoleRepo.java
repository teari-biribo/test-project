package com.web.evm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.evm.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

	Optional<Role> findByRole(String role);
	Optional<Role> findByName(String name);
}
