package com.college.student.portal.service;

import org.springframework.stereotype.Service;

import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.InternalMarksRepository;
import com.college.student.portal.repository.StudentRepository;

@Service
public class InternalMarksService {

	private final InternalMarksRepository internalMarksRepository;
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	
	public InternalMarksService(InternalMarksRepository internalMarksRepository, StudentRepository studentRepository,
			CourseRepository courseRepository) {
		super();
		this.internalMarksRepository = internalMarksRepository;
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
	// Enter Internal Marks
	
	
}
