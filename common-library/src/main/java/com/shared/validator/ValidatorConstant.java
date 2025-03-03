package com.shared.validator;

public class ValidatorConstant {

	public static final String FEEDBACK_REQUIRED = "Feedback cannot be empty.";
	public static final String FEEDBACK_LENGTH = "Feedback must be at most 500 characters long.";
	public static final String RATING_REQUIRED = "Rating is required.";
	public static final String RATING_INVALID = "Invalid rating. Allowed values: SLOW, AVERAGE, FAST, EXCEPTIONAL.";
	public static final String EMPLOYEE_ID_REQUIRED = "Employee ID is required.";
	public static final String EMPLOYEE_ID_POSITIVE = "Employee ID must be a positive number.";
	
    public static final String RATING_REGEX = "^(?i)(SLOW|AVERAGE|FAST|EXCEPTIONAL)$";


}
