package com.college.student.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.student.portal.entity.InternalMarks;

@Repository
public interface InternalMarksRepository extends JpaRepository<InternalMarks, Integer>{

}
