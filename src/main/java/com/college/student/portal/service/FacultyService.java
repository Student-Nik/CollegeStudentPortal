package com.college.student.portal.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.FacultyDTO;
import com.college.student.portal.entity.Faculty;
import com.college.student.portal.repository.FacultyRepository;

@Service
public class FacultyService {

	private final FacultyRepository facultyRepository;
	private final PasswordEncoder passwordEncoder;
	
	public FacultyService(FacultyRepository facultyRepository, PasswordEncoder passwordEncoder) {
		super();
		this.facultyRepository = facultyRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public ResponseEntity<String> registerFaculty(FacultyDTO facultyDto){
		
		Optional<Faculty> isExistingFaculty = facultyRepository.findByEmail(facultyDto.getEmail());
		
		if(isExistingFaculty.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body("This E-mail is already exists!");
		}else {
			Faculty faculty = new Faculty();
			faculty.setName(facultyDto.getName());
			faculty.setEmail(facultyDto.getEmail());
			faculty.setPasswordHash(passwordEncoder.encode(facultyDto.getPasswordHash()));
			faculty.setPhone(facultyDto.getPhone());
			faculty.setDesignation(facultyDto.getDesignation());
			faculty.setDepartment(facultyDto.getDepartment());
			
			facultyRepository.save(faculty);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("Faculty Registration Successful!");
		}
		
	}
	
}
