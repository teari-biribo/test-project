package com.web.evm.service;

import java.util.List;

import com.web.evm.entity.Event;

public interface EventService {

	List<Event> searchEvents(String query);
	List<Event> getAllEvents();
	Event saveEvent(Event event);
	Event getEventByID(int eventId);

}
