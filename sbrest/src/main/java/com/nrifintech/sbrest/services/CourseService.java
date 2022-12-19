package com.nrifintech.sbrest.services;

import java.util.List;

import com.nrifintech.sbrest.model.Course;

public interface CourseService {

	public List<Course> getCourses();
	public Course getCourse(long cid);
	public Course addCourse(Course c);
	public Course updateCourse(Course c);
	public void deleteCourse(long cid);
	
}
