package com.college.student.portal.dto;

import java.time.LocalDate;

import com.college.student.portal.enums.PaymentMode;
import com.college.student.portal.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeHistoryResponseDTO {

	private String semester;
    private Long totalFee;         
    private Long amountPaid;       
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String receiptNumber;
    private LocalDate paymentDate;
}
