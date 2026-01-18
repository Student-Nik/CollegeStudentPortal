package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.FacultyProfessionalDTO;
import com.college.student.portal.service.FacultyProfessionalService;

import jakarta.validation.Valid;

@RestController
public class FacultyProfessionalController {

	private final FacultyProfessionalService facultyProfessionalService;

	public FacultyProfessionalController(FacultyProfessionalService facultyProfessionalService) {
		super();
		this.facultyProfessionalService = facultyProfessionalService;
	}
	
	// Create Professional Faculty
	@PostMapping("/api/admin/create/professional/faculty")
	public ResponseEntity<Map<String, Object>> createPrpfessionalFaculty(@Valid @RequestBody FacultyProfessionalDTO facultyProfessionalDTO){
		return facultyProfessionalService.createFacultyProfessional(facultyProfessionalDTO);
	}
}
