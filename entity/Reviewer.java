package com.web.evm.entity;

import org.springframework.security.core.Authentication;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reviewer")
public class Reviewer {

	public Reviewer() {
			
	}

	public Reviewer(String emailAddress, String password, String username, int reviewerId) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.username = username;
		this.reviewerId = reviewerId;
	}
	
	@Id @Column(name = "REVIEWER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewerId;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "password", nullable = false, length = 64)
	private String password;
	
	@Column(name = "username", nullable = false, length = 30)
	private String username;
	
	
	public Reviewer getCurrentlyLoggedInAccount(Authentication authentication) {
		if(authentication == null)
			return null;
		
		Reviewer reviewer = null;
		Object principal = authentication.getPrincipal();
		
		if(principal instanceof Reviewer) {
			reviewer = ((Reviewer) principal).getReviewer();
		}
		
		return reviewer;
	}
	
	public int getReviewerId() {
		return reviewerId;
	}
	
	public Reviewer getReviewer() {
		return this;
	}
	
	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
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
