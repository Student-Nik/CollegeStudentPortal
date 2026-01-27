package com.college.student.portal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentsResponseDTO {

	private String courseCode;
    private String courseName;
    private int totalStudents;
    private List<CourseStudentDTO> students;
}
