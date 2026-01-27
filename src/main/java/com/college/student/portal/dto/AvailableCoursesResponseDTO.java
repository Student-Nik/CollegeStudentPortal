package com.college.student.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableCoursesResponseDTO {

	private Integer courseId;
    private String code;
    private String name;
    private String semester;
    private int credits;
}
