package com.mindfire.performancereviewservice.service;

import java.util.List;

import com.shared.request.FeedbackRequest;
import com.shared.response.FeedbackResponse;

public interface FeedbackService {

	FeedbackResponse addFeedback(FeedbackRequest feedbackRequest);

	List<FeedbackResponse> getFeedbackByEmployeeId(Long employeeId);

	FeedbackResponse getLatestFeedbackByEmployeeId(Long employeeId);

	List<FeedbackResponse> getFeedbacksForEmployeeList(List<Long> employeeIds);

}
