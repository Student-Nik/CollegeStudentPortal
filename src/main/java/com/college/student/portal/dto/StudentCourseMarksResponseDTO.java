package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseMarksResponseDTO {

	private String rollNumber;
	private String studentName;
	
	private CourseDTO course;
	private InternalMarksDTO internalMarksDto;
	private ExamMarksDTO examMarksDTO;
	
	private String grade;
}
