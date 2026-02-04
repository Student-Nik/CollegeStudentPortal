package com.college.student.portal.dto;

import java.time.LocalDate;

import com.college.student.portal.enums.TargetAudience;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {

	private Integer id;

	@NotBlank(message = "Title is required")
	@Size(max = 200, message = "Title must not exceed 200 characters")
	private String title;

	@NotBlank(message = "Content is required")
	private String content;

	@NotNull(message = "Target audience is required")
	private TargetAudience target;

	private LocalDate postedDate; 

	@NotNull(message = "Expiry date is required")
	private LocalDate expiryDate;

	@NotNull(message = "Admin ID is required")
	private Integer adminId; 
}
