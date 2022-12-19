package com.nrifintech.sbrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nrifintech.sbrest.model.Course;
import com.nrifintech.sbrest.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService cs;
	
	@GetMapping("/home")
	public String home() {
		return "Course Back End REST API Endpoints Version 1.0";
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return this.cs.getCourses();
	}
	
	@GetMapping("/courses/{cid}")
	public Course getFilteredCourse(@PathVariable long cid) {
		return this.cs.getCourse(cid);
	}
	
	@PostMapping(path = "/courses", consumes="application/json")
	public Course addNewCourse(@RequestBody Course cobj) {
		return this.cs.addCourse(cobj);
	}
	@PutMapping(path = "/courses", consumes="application/json")
	public Course updateCourse(@RequestBody Course cobj) {
		return cs.updateCourse(cobj);
	}
	@DeleteMapping(path="/courses/{cid}")
	public ResponseEntity delCourse(@PathVariable String cid) {
		try {
			this.cs.deleteCourse(Long.parseLong(cid));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
}
