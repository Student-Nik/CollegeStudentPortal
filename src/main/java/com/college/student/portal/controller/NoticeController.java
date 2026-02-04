package com.college.student.portal.controller;

import org.springframework.web.bind.annotation.RestController;

import com.college.student.portal.service.NoticeService;

@RestController
public class NoticeController {

	private final NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}
	
	
}
