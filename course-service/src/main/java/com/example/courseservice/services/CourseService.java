package com.example.courseservice.services;

import com.example.courseservice.entities.Course;
import com.example.courseservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {
@Autowired
private CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
    @Override
    public List<Course> getCourseByCategory(String category) {
        return courseRepository.findByCategory(category);
    }
}



