package com.college.student.portal.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.student.portal.dto.NoticeDTO;
import com.college.student.portal.repository.AdminRepository;
import com.college.student.portal.repository.NoticeRepository;

@Service
public class NoticeService {

	private final NoticeRepository noticeRepository;
	private final AdminRepository adminRepository;
	
	public NoticeService(NoticeRepository noticeRepository, AdminRepository adminRepository) {
		super();
		this.noticeRepository = noticeRepository;
		this.adminRepository = adminRepository;
	}
	
	// POST Notice
	public ResponseEntity<Map<String, Object>> postNotice(NoticeDTO noticeDto){
		
		return null;
	}
	
	
}
