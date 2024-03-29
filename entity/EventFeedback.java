package com.web.evm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Event_Feedback")
public class EventFeedback {

	public EventFeedback() {
		
	}
	
	public EventFeedback(int feedbackID, String comments, String applicationStatus) {
		super();
		this.feedbackID = feedbackID;
		this.comments = comments;
		this.applicationStatus = applicationStatus;
	}
	
	@Id @Column(name = "FEEDBACK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackID;
	
	@Column(name = "comments", nullable = true, length = 170)
	private String comments;
	
	@Column(name = "applicationStatus", nullable = true, length = 10)
	private String applicationStatus;

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	
}
