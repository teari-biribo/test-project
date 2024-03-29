package com.web.evm.controller;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.evm.dto.RegisterDto;
import com.web.evm.entity.Role;
import com.web.evm.entity.UserEntity;
import com.web.evm.repository.RoleRepo;
import com.web.evm.repository.UserRepo;

//@RestController
//@RequestMapping ("/auth")
public class RegistrationController {

//	private AuthenticationManager authManager;
//	private UserRepo userRepo;
//	private RoleRepo roleRepo;
//	private PasswordEncoder passwordEncoder;
//	
//	public RegistrationController(UserRepo userRepo, PasswordEncoder passwordEncoder, 
//								  RoleRepo roleRepo, AuthenticationManager authManager) {
//		this.authManager = authManager;
//		this.userRepo = userRepo;
//		this.roleRepo = roleRepo;
//		this.passwordEncoder = passwordEncoder;
//	}
//	
//	//creating register endpoint
//	@PostMapping("register")
//	public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto){
//		
//		//evaluates if username is taken; if username taken sends Bad Request response
//		if(userRepo.existsByUsername(registerDto.getUsername())) {
//			return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
//		}
//		
//		UserEntity user = new UserEntity();
//		user.setUsername(registerDto.getUsername());
//		user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
//		
//		Role roles = roleRepo.findByRole("USER").get();
//		user.setRoles(Collections.singletonList(roles));
//		
//		//saving the newly registered user
//		userRepo.save(user);
//		return new ResponseEntity<String>("Successfully registered user", HttpStatus.OK);
//	}
	
//	@PostMapping("login")
//    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
//        Authentication authentication = authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                loginDto.getUsername(),
//                loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = jwtGenerator.generateToken(authentication);
//        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
//    }
}
