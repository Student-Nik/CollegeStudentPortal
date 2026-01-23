package com.college.student.portal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {
	
	private Integer id;

	@NotNull(message = "Course id is required")
    private Integer courseId;
}
