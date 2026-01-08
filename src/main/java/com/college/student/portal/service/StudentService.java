package com.college.student.portal.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.StudentDTO;
import com.college.student.portal.entity.Student;
import com.college.student.portal.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	private final PasswordEncoder passwordEncoder;
	
	public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
		super();
		this.studentRepository = studentRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public ResponseEntity<String> registerStudent(StudentDTO studentDto){
		
		Optional<Student> isExistingStudent = studentRepository.findByEmail(studentDto.getEmail());
		
		if(isExistingStudent.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body("This E-mail is already exists!");
		}else {
			Student student = new Student();
			student.setRollNumber(studentDto.getRollNumber());
			student.setName(studentDto.getName());
			student.setEmail(studentDto.getEmail());
			student.setPhone(studentDto.getPhone());
			student.setPasswordHash(passwordEncoder.encode(studentDto.getPasswordHash()));
			student.setEnrollYear(studentDto.getEnrollYear());
			student.setSemester(studentDto.getSemester());
			student.setBranch(studentDto.getBranch());
			student.setAddress(studentDto.getAddress());
			student.setCreatedAt(studentDto.getCreatedAt());
			
			studentRepository.save(student);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("Student registered successfully!");
		}
		
	}
}
