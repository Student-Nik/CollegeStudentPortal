package com.college.student.portal.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.AdminDTO;
import com.college.student.portal.entity.Admin;
import com.college.student.portal.enums.Role;
import com.college.student.portal.repository.AdminRepository;

@Service
public class AdminService {

	private final AdminRepository adminRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
		super();
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public ResponseEntity<Map<String, Object>> registerAdmin(AdminDTO adminDto){
		
		Optional<Admin> isExistingAdmin = adminRepository.findByEmail(adminDto.getEmail());
		
		if(isExistingAdmin.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(Map.of("message","This E-mail already exists, please try another one!"));
		}else {
			Admin admin = new Admin();
			admin.setName(adminDto.getName());
			admin.setEmail(adminDto.getEmail());
			admin.setPasswordHash(passwordEncoder.encode(adminDto.getPasswordHash()));
			admin.setPhone(adminDto.getPhone());
			
			admin.setRole(Role.ADMIN);
			
			adminRepository.save(admin);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(Map.of("message","Admin Registration Successful!",
							"role",admin.getRole()));
			
		}
	}
	
	
}
