package com.college.student.portal.controller;

import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.service.FacultySubjectService;

@RestController
public class FacultySubjectController {

	private final FacultySubjectService facultySubjectService;

	public FacultySubjectController(FacultySubjectService facultySubjectService) {
		super();
		this.facultySubjectService = facultySubjectService;
	}
	
	
}
