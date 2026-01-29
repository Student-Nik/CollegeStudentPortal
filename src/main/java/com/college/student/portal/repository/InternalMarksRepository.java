package com.college.student.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.Course;
import com.college.student.portal.entity.InternalMarks;
import com.college.student.portal.entity.Student;

@Repository
public interface InternalMarksRepository extends JpaRepository<InternalMarks, Integer>{

	Optional<InternalMarks> findByStudentAndCourse(Student student, Course course);

}
