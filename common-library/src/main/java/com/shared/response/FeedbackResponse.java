package com.shared.response;


import com.shared.enums.Rating;

import lombok.Data;

@Data
public class FeedbackResponse {
	 private Long id;
	    private Long employeeId;
	    private String feedback;
	    private Rating rating;
	    
	    
	    
	    public FeedbackResponse() {
	        this.id = null; 
	        this.employeeId = 0L; 
	        this.feedback = "Service is currently unavailable. Please try again later."; 
	        this.rating = Rating.AVERAGE;
	    }
}
