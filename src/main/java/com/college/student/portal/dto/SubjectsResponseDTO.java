package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectsResponseDTO {

	public String code;
	public String name;
	public int credits;
	public String semester;
	public String department;
}
