package com.web.evm.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {

	public UserEntity() {
			
	}

	public UserEntity(String emailAddress, String password, String username, int userId) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.username = username;
		this.userId = userId;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "roleID", referencedColumnName = "role_id"))
	
	private List<Role> roles = new ArrayList<>();
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Id @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "password", nullable = false, length = 64)
	private String password;
	
	@Column(name = "username", nullable = false, length = 30)
	private String username;
	
	
	public UserEntity getCurrentlyLoggedInAccount(Authentication authentication) {
		if(authentication == null)
			return null;
		
		UserEntity user = null;
		Object principal = authentication.getPrincipal();
		
		if(principal instanceof UserEntity) {
			user = ((UserEntity) principal).getUser();
		}
		
		return user;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public UserEntity getUser() {
		return this;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
