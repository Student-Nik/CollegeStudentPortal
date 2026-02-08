package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SemesterFeeReportsResponseDTO {

	private String semester;
    private int totalStudents;
    private double totalFeeExpected;
    private double totalFeeCollected;
    private double totalFeePending;
}
