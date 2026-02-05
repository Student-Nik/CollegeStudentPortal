package com.college.student.portal.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponseDTO {

	private String title;
	private String content;
	private LocalDate postedDate;
	private LocalDate expiryDate;
}
