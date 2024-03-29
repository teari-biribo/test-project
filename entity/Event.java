package com.web.evm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Event")
public class Event {

	public Event() {
		
	}
	
	public Event(String emailAddress, String username, String firstName, String lastName,
				 String location,String description, String title, String time, String date, String dateTime,
				 String sponsor, String applicationStatus, Boolean applicationPermission, int personalContactNum, 
				 int workContactNum, int budget, int eventId) {
		
		super();
		this.emailAddress = emailAddress;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eventId = eventId;
		this.location = location;
		this.description = description;
		this.title = title;
		this.time = time;
		this.date = date;
		this.dateTime = dateTime;
		this.sponsor = sponsor;
		this.applicationStatus = applicationStatus;
		this.applicationPermission = applicationPermission;
		this.personalContactNum = personalContactNum;
		this.workContactNum = workContactNum;
		this.budget = budget;
	}

	@Id @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	
	@Column(name = "email_address", nullable = false, length = 50)
	private String emailAddress;
	
	@Column(name = "username", nullable = true, length = 30)
	private String username;
	
	@Column(name = "first_name", nullable = false, length = 30)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 30)
	private String lastName;
	
	@Column(name = "location", nullable = false, length = 30)
	private String location;
	
	@Column(name = "description", nullable = true, length = 170)
	private String description;

	@Column(name = "title", nullable = false, length = 50)
	private String title;

	@Column(name = "time", nullable = true, length = 12)
	private String time;
	
	@Column(name = "date", nullable = true, length = 16)
	private String date;
	
	@Column(name = "date_time", nullable = false, length = 30)
	private String dateTime;

	@Column(name = "sponsor", nullable = false, length = 30)
	private String sponsor;
	
	@Column(name = "application_status", nullable = true, length = 10)
	private String applicationStatus = "pending";
	
	@Column(name = "application_permission", nullable = true, length = 5)
	private Boolean applicationPermission;
	
	@Column(name = "personal_contact_num", nullable = true, length = 9)
	private int personalContactNum;
	
	@Column(name = "work_contact_num", nullable = true, length = 9)
	private int workContactNum;
	
	@Column(name = "budget", nullable = false, length = 15)
	private int budget;
	
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getStatus() {
		return applicationStatus;
	}

	public void setStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
	public String getSponsor() {
		return sponsor;
	}
	
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	
	public Boolean getApplicationPermission() {
		return applicationPermission;
	}
	
	public void setApplicationPermission(Boolean applicationPermision) {
		this.applicationPermission = applicationPermision;
	}
	
	public int getPersonalContactNum() {
		return personalContactNum;
	}
	
	public void setPersonalContactNum(int personalContactNum) {
		this.personalContactNum = personalContactNum;
	}
	
	public int getWorkContactNum() {
		return personalContactNum;
	}
	
	public void setWorkContactNum(int budget) {
		this.budget = budget;
	}
	
	public int getBudget() {
		return budget;
	}
}
