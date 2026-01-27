package com.college.student.portal.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import com.college.student.portal.enums.AttendanceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	private AttendanceStatus status;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalTime markedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	private FacultyProfessional facultyProfessional;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Course course;

}
