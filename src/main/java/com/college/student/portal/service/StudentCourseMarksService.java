package com.college.student.portal.service;

import org.springframework.stereotype.Service;

import com.college.student.portal.dto.CourseDTO;
import com.college.student.portal.dto.ExamMarksDTO;
import com.college.student.portal.dto.InternalMarksDTO;
import com.college.student.portal.dto.StudentCourseMarksResponseDTO;
import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.ExamMarks;
import com.college.student.portal.entity.InternalMarks;
import com.college.student.portal.entity.Student;
import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.ExamMarksRepository;
import com.college.student.portal.repository.InternalMarksRepository;
import com.college.student.portal.repository.StudentRepository;
import com.college.student.portal.util.GradeUtil;

@Service
public class StudentCourseMarksService {

	private final StudentRepository studentRepository;
	private CourseRepository courseRepository;
	private final InternalMarksRepository internalMarksRepository;
	private final ExamMarksRepository examMarksRepository;
	
	public StudentCourseMarksService(StudentRepository studentRepository, CourseRepository courseRepository,
			InternalMarksRepository internalMarksRepository, ExamMarksRepository examMarksRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.internalMarksRepository = internalMarksRepository;
		this.examMarksRepository = examMarksRepository;
	}

	// Fetch Student Mark sheet
	public StudentCourseMarksResponseDTO getMarkSheetofStudentWithCourse(String studentRoll, String courseCode) {
		
		Student student = studentRepository.findByRollNumber(studentRoll)
				.orElseThrow(() -> new RuntimeException("Student not found!"));
		
		Course course = courseRepository.findByCode(courseCode)
				.orElseThrow(() -> new RuntimeException("Course not found!"));
		
		InternalMarks internalMarks = internalMarksRepository
		        .findByStudent_StudentIdAndCourse_Id(student.getStudentId(), course.getId())
		        .orElseThrow(() -> new RuntimeException("Internal Marks not found!"));

		ExamMarks examMarks = examMarksRepository
		        .findByStudent_StudentIdAndCourse_Id(student.getStudentId(), course.getId())
		        .orElseThrow(() -> new RuntimeException("Exam Marks not found!"));
		
		String grade = GradeUtil.calculateGrade(examMarks.getTotalMarks());
		
		StudentCourseMarksResponseDTO response = new StudentCourseMarksResponseDTO();
	    response.setRollNumber(student.getRollNumber());
	    response.setStudentName(student.getName());

	    CourseDTO courseDTO = new CourseDTO();
	    courseDTO.setId(course.getId());
	    courseDTO.setCode(course.getCode());
	    courseDTO.setName(course.getName());
	    courseDTO.setSemester(course.getSemester());

	    response.setCourse(courseDTO);


	    InternalMarksDTO internalDTO = new InternalMarksDTO();
	    internalDTO.setQuiz1(internalMarks.getQuiz1());
	    internalDTO.setQuiz2(internalMarks.getQuiz2());
	    internalDTO.setAssignment1(internalMarks.getAssignment1());
	    internalDTO.setAssignment2(internalMarks.getAssignment2());
	    internalDTO.setMidSem(internalMarks.getMidSem());
	    internalDTO.setTotalInternal(internalMarks.getTotalInternal());
	    
	    response.setInternalMarksDto(internalDTO);

	    ExamMarksDTO examDTO = new ExamMarksDTO();
	    examDTO.setEndSemMarks(examMarks.getEndSemMarks());
	    examDTO.setTotalMarks(examMarks.getTotalMarks());
	    
	    response.setExamMarksDTO(examDTO);

	    response.setGrade(grade);

	    return response;
	}
}
