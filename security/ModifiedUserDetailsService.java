package com.web.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.evm.entity.Role;
import com.web.evm.entity.UserEntity;
import com.web.evm.repository.UserRepo;

@Service
public class ModifiedUserDetailsService implements UserDetailsService {

	private UserRepo userRepo;

	public ModifiedUserDetailsService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	private Collection<GrantedAuthority> roleToAuthorityMapping(List<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userRepo.findByUsername(username);
		
		if(user.equals(null))
			throw new UsernameNotFoundException("Username not found");
		
		else 
			return new User(user.getUsername(), user.getPassword(), roleToAuthorityMapping(user.getRoles()));
	}

}
