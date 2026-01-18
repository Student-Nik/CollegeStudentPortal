package com.college.student.portal.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FacultyProfessional {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	private String employeeId;
	private String designation;
	private String department;
	private LocalDate joiningDate;
	private BigDecimal salary;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="faculty_personal_id")
	private Faculty faculty;
}
