package com.college.student.portal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.StudentDTO;
import com.college.student.portal.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping("/api/auth/student/register")
	public ResponseEntity<String> registerStudent(@Valid @RequestBody StudentDTO studentDto){
		return studentService.registerStudent(studentDto);
	}
}
