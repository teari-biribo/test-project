package com.web.evm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.evm.entity.EventFeedback;

public interface EventFeedbackRepo extends JpaRepository<EventFeedback, Integer>{

}
