package com.shared.request;



import com.shared.validator.ValidatorConstant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FeedbackRequest {
	
	   @NotBlank(message = ValidatorConstant.FEEDBACK_REQUIRED)
	    @Size(max = 500, message = ValidatorConstant.FEEDBACK_LENGTH)
	    private String feedback;

	    @NotBlank(message = ValidatorConstant.RATING_REQUIRED)
	    @Pattern(regexp = ValidatorConstant.RATING_REGEX, message = ValidatorConstant.RATING_INVALID)
	    private String rating;

	    @NotNull(message = ValidatorConstant.EMPLOYEE_ID_REQUIRED)
	    @Positive(message = ValidatorConstant.EMPLOYEE_ID_POSITIVE)
	    private Long employeeId;

}
