package com.college.student.portal.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.EnrollmentDTO;
import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.Enrollment;
import com.college.student.portal.entity.Student;
import com.college.student.portal.enums.EnrollmentStatus;
import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.EnrollmentRepository;
import com.college.student.portal.repository.StudentRepository;

@Service
public class EnrollmentService {

	private final EnrollmentRepository enrollmentRepository;
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	
	public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository,
			CourseRepository courseRepository) {
		super();
		this.enrollmentRepository = enrollmentRepository;
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
	// Enroll Student for Course
	public ResponseEntity<Map<String, Object>> enrollStudent(
	        String roll,
	        EnrollmentDTO enrollmentDto) {

	    // check student (USE roll from URL)
	    Student student = studentRepository.findByRollNumber(roll)
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    // check course (no change)
	    Course course = courseRepository.findById(enrollmentDto.getCourseId())
	            .orElseThrow(() -> new RuntimeException("Course not found!"));

	    // check existing enrollment
	    Optional<Enrollment> existingEnrollment =
	            enrollmentRepository
	                    .findByStudent_RollNumberAndCourse_Id(
	                            roll,                      
	                            enrollmentDto.getCourseId()
	                    );

	    // check semester matches or not
	    if (!student.getSemester().equals(course.getSemester())) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(Map.of("message", "Semester mismatch!"));
	    }

	    if (existingEnrollment.isPresent()) {

	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("message", "Student already enrolled for this course!"));

	    } else {

	        Enrollment enrollment = new Enrollment();
	        enrollment.setEnrollDate(LocalDate.now());
	        enrollment.setStatus(EnrollmentStatus.ACTIVE);
	        enrollment.setStudent(student);
	        enrollment.setCourse(course);

	        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(Map.of(
	                        "message", "Enrolled Successfully!",
	                        "enrollmentId", savedEnrollment.getId()   // ← FIXED
	                ));
	    }
	}

	
}
