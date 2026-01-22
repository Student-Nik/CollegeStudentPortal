package com.college.student.portal.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Integer id;

    @NotBlank(message = "Course code is required")
    @Size(min = 3, max = 10, message = "Course code must be between 3 and 10 characters")
    private String code;

    @NotBlank(message = "Course name is required")
    @Size(min = 3, max = 100, message = "Course name must be at least 3 characters")
    private String name;

    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Semester must be greater than or equal to 1")
    private Integer semester;

    @Min(value = 1, message = "Credits must be at least 1")
    private int credits;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Academic year is required")
    @Pattern(
        regexp = "\\d{4}-\\d{2}",
        message = "Academic year must be in format YYYY-YY (e.g. 2025-26)"
    )
    private String academicYear;

    private LocalDate startDate;
    private LocalDate endDate;

    @NotNull(message = "Faculty ID is required")
    private Integer facultyProfessionalId;
}
