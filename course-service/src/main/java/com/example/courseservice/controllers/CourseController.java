package com.example.courseservice.controllers;

import com.example.courseservice.entities.Course;
import com.example.courseservice.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        try {
            List<Course> courses = courseService.getCourses();
            if (courses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        try {
            Course newCourse = courseService.addCourse(course);
            return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        try {
            Course newCourse = courseService.updateCourse(course);
            return new ResponseEntity<>(newCourse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") String id){
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String id){
        try {
            Course course = courseService.getCourseById(id).get();
            if (course == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Course>> getCourseByName(@PathVariable("name") String name){
        try {
            List<Course> courses = courseService.getCourseByName(name);
            if (courses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Course>> getCourseByCategory(@PathVariable("category") String category){
        try {
            List<Course> courses = courseService.getCourseByCategory(category);
            if (courses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
