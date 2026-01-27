package com.college.student.portal.dto;

import java.time.LocalDate;

import com.college.student.portal.enums.EnrollmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentDTO {

	private String rollNumber;
    private String name;
    private String email;
    private LocalDate enrollDate;
    private EnrollmentStatus status;
}
