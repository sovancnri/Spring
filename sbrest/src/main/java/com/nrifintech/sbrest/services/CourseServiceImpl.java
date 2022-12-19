package com.nrifintech.sbrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrifintech.sbrest.dao.CourseDao;
import com.nrifintech.sbrest.model.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao cdao;
	
	@Override
	public List<Course> getCourses() {
		return cdao.findAll();
	}
	@Override
	public Course getCourse(long cid) {
		return cdao.getOne(cid);
	}
	
	@Override
	public Course addCourse(Course c) {
		return cdao.save(c);
	}
	@Override
	public Course updateCourse(Course c) {
		return cdao.save(c);
	}
	@Override
	public void deleteCourse(long cid) {
		Course c = cdao.getOne(cid);
		cdao.delete(c);
	}

}
