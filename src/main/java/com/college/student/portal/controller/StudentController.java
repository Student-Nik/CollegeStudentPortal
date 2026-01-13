package com.college.student.portal.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.ApiResponse;
import com.college.student.portal.dto.JwtLoginResponse;
import com.college.student.portal.dto.LoginRequest;
import com.college.student.portal.dto.StudentDTO;
import com.college.student.portal.entity.Student;
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
	public ResponseEntity<Map<String, Object>> registerStudent(@Valid @RequestBody StudentDTO studentDto){
		return studentService.registerStudent(studentDto);
	}
	
	@PostMapping("/api/auth/student/login")
	public ResponseEntity<ApiResponse<JwtLoginResponse>> loginStudent(@RequestBody LoginRequest loginRequest){
		return studentService.loginStudent(loginRequest);
	}
	
	@GetMapping("/api/show/students")
	public List<Student> showStudents(){
		return studentService.showStudent();
	}
	
	@GetMapping("/api/show/student/{id}")
	public Optional<Student> showStudent(@PathVariable int id){
		return studentService.showStudent(id);
	}
}
