package com.example.courseservice.services;

import com.example.courseservice.entities.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(String id);
    public Optional<Course> getCourseById(String id);
    public List<Course> getCourseByName(String name);
    public List<Course> getCourses();
    public List<Course> getCourseByCategory(String category);

}
