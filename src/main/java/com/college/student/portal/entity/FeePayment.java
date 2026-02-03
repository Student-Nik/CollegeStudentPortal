package com.college.student.portal.entity;

import java.time.LocalDate;

import com.college.student.portal.enums.PaymentMode;
import com.college.student.portal.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class FeePayment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Long amountPaid;
	private LocalDate paymentDate;
	
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	@Column(nullable = false, unique = true)
	private String receiptNumber;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_roll")
	private Student student;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fee_structure_id")
	private FeeStructure feeStructure;
}
