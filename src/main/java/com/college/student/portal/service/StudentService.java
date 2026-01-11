package com.college.student.portal.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.ApiResponse;
import com.college.student.portal.dto.JwtLoginResponse;
import com.college.student.portal.dto.LoginRequest;
import com.college.student.portal.dto.StudentDTO;
import com.college.student.portal.entity.Student;
import com.college.student.portal.enums.Role;
import com.college.student.portal.repository.StudentRepository;
import com.college.student.portal.security.JwtUtil;
import com.college.student.portal.security.StudentUserDetails;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	
	public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil,
			AuthenticationManager authenticationManager) {
		super();
		this.studentRepository = studentRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}

	// Register Student
	public ResponseEntity<Map<String,Object>> registerStudent(StudentDTO studentDto){
		
		Optional<Student> isExistingStudent = studentRepository.findByEmail(studentDto.getEmail());
		
		if(isExistingStudent.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(Map.of("message","This E-mail already exists, please try another one!"));
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
			
			student.setRole(Role.STUDENT);
			
			studentRepository.save(student);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(Map.of("message","Student Registration Successful!",
							"role",student.getRole()));
		}	
	}
	
	//Login Student
	public ResponseEntity<ApiResponse<JwtLoginResponse>> loginStudent(LoginRequest loginRequest){
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginRequest.getEmail(),
							loginRequest.getPassword()
							));
		
			Student student = studentRepository.findByEmail(loginRequest.getEmail())
					.orElseThrow(() -> new RuntimeException("Student not found!"));
			
			StudentUserDetails userDetails = new StudentUserDetails(student);
			
			String token = jwtUtil.createToken(userDetails.getUsername());

            JwtLoginResponse jwtResponse = new JwtLoginResponse();
            jwtResponse.setToken(token);
            jwtResponse.setUsername(student.getEmail());
            jwtResponse.setRole(student.getRole());

            return ResponseEntity.ok(
                    new ApiResponse<>(
                            true,
                            "Login successful!",
                            jwtResponse
                    )
            );
			
		}catch(BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(
                            false,
                            "Invalid Credentials!",
                            null
                    ));
		}
	}
	
	
}
