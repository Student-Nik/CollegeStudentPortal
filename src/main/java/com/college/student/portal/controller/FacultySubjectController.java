package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.FacultySubjectDTO;
import com.college.student.portal.service.FacultySubjectService;

import jakarta.validation.Valid;

@RestController
public class FacultySubjectController {

	private final FacultySubjectService facultySubjectService;

	public FacultySubjectController(FacultySubjectService facultySubjectService) {
		super();
		this.facultySubjectService = facultySubjectService;
	}
	
	// Assign Subject
	@PostMapping("/api/admin/assign/subject")
	public ResponseEntity<Map<String, Object>> assignSubject(@Valid @RequestBody FacultySubjectDTO facultySubjectDto){
		return facultySubjectService.assignSubject(facultySubjectDto);
	}
	
}
