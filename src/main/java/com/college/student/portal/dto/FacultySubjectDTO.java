package com.college.student.portal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultySubjectDTO {

	private Integer id;

    @NotNull(message = "Academic year is required")
    @Positive(message = "Academic year must be a positive number")
    private Long academicYear;

    @NotNull(message = "Faculty id is required")
    @Positive(message = "Faculty id must be a positive number")
    private Integer facultyId;

    @NotNull(message = "Subject id is required")
    @Positive(message = "Subject id must be a positive number")
    private Integer subjectId;
}
