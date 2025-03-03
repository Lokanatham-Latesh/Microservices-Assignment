package com.mindfire.performancereviewservice.repository;

import com.mindfire.performancereviewservice.entity.Feedback;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	List<Feedback> findByEmployeeId(Long employeeId);

	@Query(value = "SELECT * FROM feedback WHERE employee_id = :employeeId ORDER BY id DESC LIMIT 1", nativeQuery = true)
	Feedback findLatestFeedbackByEmployeeId(Long employeeId);

	List<Feedback> findByEmployeeIdIn(List<Long> employeeIds);

	@Query("SELECT DISTINCT f.employeeId FROM Feedback f WHERE f.employeeId IN :employeeIds")
	List<Long> findDistinctEmployeeIds(List<Long> employeeIds);

}
