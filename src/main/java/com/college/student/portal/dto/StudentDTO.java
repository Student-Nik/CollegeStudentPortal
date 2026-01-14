package com.college.student.portal.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	private Integer studentId;
	
    @NotBlank(message = "Roll number is required")
    @Size(min = 3, max = 20, message = "Roll number must be between 3 and 20 characters")
    private String rollNumber;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phone;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String passwordHash;

    @Min(value = 2000, message = "Enrollment year must be valid")
    @Max(value = 2100, message = "Enrollment year must be valid")
    private int enrollYear;

    @NotBlank(message = "Semester is required")
    private String semester;

    @NotBlank(message = "Branch is required")
    private String branch;

    @Size(max = 500, message = "Address cannot exceed 500 characters")
    private String address;

    private LocalDateTime createdAt;
}
