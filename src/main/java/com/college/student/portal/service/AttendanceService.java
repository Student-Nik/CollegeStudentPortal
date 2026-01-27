package com.college.student.portal.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.AttendanceDTO;
import com.college.student.portal.entity.Attendance;
import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.FacultyProfessional;
import com.college.student.portal.entity.Student;
import com.college.student.portal.repository.AttendanceRepository;
import com.college.student.portal.repository.CourseRepository;
import com.college.student.portal.repository.FacultyProfessionalRepository;
import com.college.student.portal.repository.StudentRepository;

@Service
public class AttendanceService {

	private final AttendanceRepository attendanceRepository; 
	private final StudentRepository studentRepository;
	private final FacultyProfessionalRepository facultyProfessionalRepository;
	private final CourseRepository courseRepository;
	
	public AttendanceService(AttendanceRepository attendanceRepository, StudentRepository studentRepository,
			FacultyProfessionalRepository facultyProfessionalRepository, CourseRepository courseRepository) {
		super();
		this.attendanceRepository = attendanceRepository;
		this.studentRepository = studentRepository;
		this.facultyProfessionalRepository = facultyProfessionalRepository;
		this.courseRepository = courseRepository;
	}

	// Mark Attendance
	public ResponseEntity<Map<String, Object>> markAttendance(
	        AttendanceDTO attendanceDto,
	        Integer facultyId,
	        Integer courseId) {

	    Student student = studentRepository.findById(attendanceDto.getStudentId())
	            .orElseThrow(() -> new RuntimeException("Student not found!"));

	    FacultyProfessional facultyProfessional = facultyProfessionalRepository.findById(facultyId)
	            .orElseThrow(() -> new RuntimeException("Faculty not found!"));

	    Course course = courseRepository.findById(courseId)
	            .orElseThrow(() -> new RuntimeException("Course not found!"));

	    Optional<Attendance> existingAttendance =
	            attendanceRepository.findByStudentAndDateAndCourse(
	                    student,
	                    attendanceDto.getDate(),
	                    course
	            );

	    if (existingAttendance.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("message", "Attendance already marked!"));
	    }

	    Attendance attendance = new Attendance();
	    attendance.setDate(attendanceDto.getDate());
	    attendance.setStatus(attendanceDto.getStatus());
	    attendance.setStudent(student);
	    attendance.setFacultyProfessional(facultyProfessional);
	    attendance.setCourse(course);

	    attendanceRepository.save(attendance);

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(Map.of("message", "Attendance Marked Successfully!"));
	}

}
