package com.college.student.portal.dto;

import java.time.LocalDate;

import com.college.student.portal.enums.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayAttendanceDTO {
	
	private LocalDate date;
    private AttendanceStatus status;
}
