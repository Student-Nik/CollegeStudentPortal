package com.college.student.portal.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	private String name;
	private Integer semester;
	private int credits;
	private String department;
	private String academicYear;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="faculty_id")
	private FacultyProfessional facultyProfessional;
}
