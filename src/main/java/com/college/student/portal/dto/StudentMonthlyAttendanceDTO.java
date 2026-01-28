package com.college.student.portal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentMonthlyAttendanceDTO {

	private String rollNumber;
    private String studentName;
    private List<DayAttendanceDTO> attendance;
}
