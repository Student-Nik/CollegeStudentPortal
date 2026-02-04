package com.college.student.portal.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.college.student.portal.entity.Notice;
import com.college.student.portal.enums.TargetAudience;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>{

	boolean existsByTitleAndTargetAndPostedDate(
		    String title,
		    TargetAudience target,
		    LocalDate postedDate
		);

}
