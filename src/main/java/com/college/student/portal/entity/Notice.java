package com.college.student.portal.entity;

import java.time.LocalDate;

import com.college.student.portal.enums.TargetAudience;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	private String content;
	
	@Enumerated(EnumType.STRING)
	private TargetAudience target;
	
	private LocalDate postedDate;
	private LocalDate expiryDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="posted_by")
	private Admin admin;
}
