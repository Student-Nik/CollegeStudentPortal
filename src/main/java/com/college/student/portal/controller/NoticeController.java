package com.college.student.portal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.dto.NoticeDTO;
import com.college.student.portal.service.NoticeService;

import jakarta.validation.Valid;

@RestController
public class NoticeController {

	private final NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}
	
	// POST Notice
	@PostMapping("/api/admin/notices")
	public ResponseEntity<Map<String, Object>> postNotice(@Valid @RequestBody NoticeDTO noticeDto){
		return noticeService.postNotice(noticeDto);
	}
}
