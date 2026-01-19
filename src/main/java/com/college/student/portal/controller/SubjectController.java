package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.SubjectDTO;
import com.college.student.portal.service.SubjectService;

import jakarta.validation.Valid;

@RestController
public class SubjectController {

	private final SubjectService subjectService;

	public SubjectController(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}
	
	// Add Subject
	@PostMapping("/api/subjects/add")
	public ResponseEntity<Map<String, Object>> addSubject(@Valid @RequestBody SubjectDTO subjctDto){
		return subjectService.addSubject(subjctDto);
	}
}
