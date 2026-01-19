package com.college.student.portal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyProfessionalResponseDTO {

	private String employeeId;
	private String designation;
	private String department;
	private LocalDate joiningDate;
	private BigDecimal salary;
}
