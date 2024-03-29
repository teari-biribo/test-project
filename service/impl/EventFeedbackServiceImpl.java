package com.web.evm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.evm.entity.EventFeedback;
import com.web.evm.repository.EventFeedbackRepo;
import com.web.evm.service.EventFeedbackService;

@Service
public class EventFeedbackServiceImpl implements EventFeedbackService{

	@Autowired
	private EventFeedbackRepo eventFeedbackRepo;
	
	public EventFeedbackServiceImpl(EventFeedbackRepo eventFeedbackRepo) {
		super();
		this.eventFeedbackRepo = eventFeedbackRepo;
	}
	
	@Override
	public EventFeedback saveEventFeedback(EventFeedback eventFeedback) {
		return eventFeedbackRepo.save(eventFeedback);
	}

}
