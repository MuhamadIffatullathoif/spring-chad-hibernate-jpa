package com.iffat.springchadhibernatejpa.dao;

import com.iffat.springchadhibernatejpa.entity.Course;
import com.iffat.springchadhibernatejpa.entity.Instructor;
import com.iffat.springchadhibernatejpa.entity.InstructorDetail;
import com.iffat.springchadhibernatejpa.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor instructor);
    Course findCourseById(int id);
    void update(Course course);
    void deleteCourseById(int id);
    void save(Course course);
    Course findCourseAndReviewsByCourseId(int id);
    Course findCourseAndStudentByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    void update(Student student);
}
