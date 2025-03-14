package com.mindfire.performancereviewservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindfire.performancereviewservice.request.FeedbackRequest;
import com.mindfire.performancereviewservice.response.FeedbackResponse;
import com.mindfire.performancereviewservice.service.FeedbackService;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping
	public ResponseEntity<FeedbackResponse> addFeedback(@Valid @RequestBody FeedbackRequest feedbackRequest) {
		FeedbackResponse feedbackResponse = feedbackService.addFeedback(feedbackRequest);
		return ResponseEntity.ok(feedbackResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<FeedbackResponse>> getFeedbackByEmployeeId(@PathVariable long id) {
		List<FeedbackResponse> feedbackResponses = feedbackService.getFeedbackByEmployeeId(id);
		return ResponseEntity.ok(feedbackResponses);
	}

	@GetMapping("/latest/{employeeId}")
	public ResponseEntity<FeedbackResponse> getLatestFeedbackByEmployeeId(@PathVariable Long employeeId) {
		FeedbackResponse feedbackResponse = feedbackService.getLatestFeedbackByEmployeeId(employeeId);
		return ResponseEntity.ok(feedbackResponse);
	}

	@GetMapping("/list")
	public ResponseEntity<List<FeedbackResponse>> getFeedbacksForEmployeeList(@RequestParam List<Long> employeeIds) {
		List<FeedbackResponse> feedbackResponses = feedbackService.getFeedbacksForEmployeeList(employeeIds);
		return ResponseEntity.ok(feedbackResponses);
	}

}