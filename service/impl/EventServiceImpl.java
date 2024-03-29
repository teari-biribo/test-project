package com.web.evm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.evm.entity.Event;
import com.web.evm.repository.EventRepo;
import com.web.evm.service.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepo eventRepo;
		
	public EventServiceImpl(EventRepo eventRepo) {
		super();
		this.eventRepo = eventRepo;
	}
	
	@Override
	public List<Event> searchEvents(String query) {
		List<Event> events = eventRepo.searchEvents(query);
        return events;
	}
	
	@Override
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}
	
	@Override
	public Event saveEvent(Event event) {
		return eventRepo.save(event);
	}

	@Override
	public Event getEventByID(int eventId) {
		return eventRepo.findById(eventId).get();
	}

}
