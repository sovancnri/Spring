package com.nrifintech.sbrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrifintech.sbrest.model.Course;

//JpaRepository contains all the Dao Operations implemented
public interface CourseDao extends JpaRepository<Course, Long>{

}
