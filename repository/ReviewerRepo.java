package com.web.evm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.evm.entity.Reviewer;

public interface ReviewerRepo extends JpaRepository<Reviewer, String>{

}
