package com.college.student.portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	public String code;
	public String name;
	public int credits;
	public String semester;
	public String department;
}
