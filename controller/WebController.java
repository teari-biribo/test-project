package com.web.evm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.evm.entity.Event;
import com.web.evm.entity.EventFeedback;
import com.web.evm.repository.UserRepo;
import com.web.evm.service.EventFeedbackService;
import com.web.evm.service.EventService;

@Controller
public class WebController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	EventService eventService; 
	
	@Autowired
	EventFeedbackService eventFeedbackService; 
	
	/*****navigation methods to handle the user's navigation*****/
	
	//Student view
	@GetMapping("/home_page")
	public String showHomePage() {
		return "home_page";
	}
	
	//Reviewer view
	@GetMapping("/reviewer_home")
	public String showReviewerHomePage() {
		return "reviewer_home";
	}
	
	//search function handler
	@GetMapping("/search")
    public String search(Model model, @RequestParam("query") String query){
		List<Event> events = eventService.searchEvents(query);
		model.addAttribute("events", events);
		return "search_results";
    }

	/*********form handling methods*********/
		
	/***event application form handler****/
	
	//displays event application form
	@GetMapping("/application_form")
	public String showApplicationForm(Model model) {
		model.addAttribute("event", new Event());
		return "application_form";
	}
	
	//submits event application form
	@PostMapping("/submit_application_form")
	public String submitApplicationForm(Event event){
		eventService.saveEvent(event);
		return "home_page";
	}
	
	/***event review form handler****/
	
	//displays event applications
	@GetMapping("/review/events")
	public String showApplicationsPage(Model model) {
		List<Event> applicationList = eventService.getAllEvents();
		model.addAttribute("applicationList", applicationList);
		return "applications";
	}
	
	//displays selected event application
	@GetMapping("/review/events/feedback/{id}")
	public String showEventReviewForm(@PathVariable int id, Model model) {
		model.addAttribute("event", eventService.getEventByID(id));
		model.addAttribute("eventFeedback", new EventFeedback());
		return "event_review_form";
	}
	
	//submits feedback for application
	@PostMapping(value="/review/feedback", params = "accept")
	public String submitAcceptEventForm(EventFeedback eventFeedback) {
		eventFeedback.setApplicationStatus("accepted");
		eventFeedbackService.saveEventFeedback(eventFeedback);
		return "applications";
	}
	
	//submits feedback for application
	@PostMapping(value="/review/feedback", params = "reject")
	public String submitRejectEventForm(EventFeedback eventFeedback) {
		eventFeedback.setApplicationStatus("rejected");
		eventFeedbackService.saveEventFeedback(eventFeedback);
		return "applications";
	}
		
//	@PostMapping(value = "/submit_event_review_form", params = "accept")
//	public String submitPositiveFeedbackForm(EventFeedback eventFeedback){
//		eventFeedbackRepo.save(eventFeedback);
//		return "redirect:/reviewer_home";
//	}
//	
//	@PostMapping(value = "/submit_event_review_form", params = "reject")
//	public String submitNegativeFeedbackForm(EventFeedback eventFeedback){
//		eventFeedbackRepo.save(eventFeedback);
//		return "redirect:/reviewer_home";
//	}
	
}
