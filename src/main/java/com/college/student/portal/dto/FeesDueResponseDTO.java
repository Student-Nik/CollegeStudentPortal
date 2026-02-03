package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeesDueResponseDTO {

	private String semester;
	private Long totalFee;
    private Long amountPaid;
    private Long pendingAmount;
}
