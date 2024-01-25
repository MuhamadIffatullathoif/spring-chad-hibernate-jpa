package com.iffat.springchadhibernatejpa;

import com.iffat.springchadhibernatejpa.dao.AppDAO;
import com.iffat.springchadhibernatejpa.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringChadHibernateJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringChadHibernateJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);
            // findInstructorDetail(appDAO);
            // deleteInstructorDetail(appDAO);
            // createInstructorWithCourses(appDAO);
            // findInstructorWithCourses(appDAO);
            // findCoursesForInstructor(appDAO);
            // findInstructorJoinFetch(appDAO);
            // updateInstructor(appDAO);
            // updateCourse(appDAO);
            // deleteInstructor(appDAO);
            // deleteCourse(appDAO);
            // createCourseAndReviews(appDAO);
            // retrieveCourseAndReviews(appDAO);
            // deleteCourseAndReviews(appDAO);
            // createCourseAndStudents(appDAO);
            // findCourseAndStudents(appDAO);
            findStudentAndCourses(appDAO);
        };
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int id = 1;
        Student student = appDAO.findStudentAndCoursesByStudentId(id);
        System.out.println(student);
        System.out.println(student.getCourses());
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndStudentByCourseId(id);
        System.out.println(course);
        System.out.println(course.getStudents());
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        Course course = new Course("Spring Boot Master 2024");

        Student student1 = new Student("Muhamad","Iffat","iffat@gmail.com");
        Student student2 = new Student("Faqih","fahmi","faqih@gmail.com");

        course.addStudent(student1);
        course.addStudent(student2);

        appDAO.save(course);
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        appDAO.deleteCourseById(id);
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("Spring Boot Master 2024");

        course.addReview(new Review("The best course"));
        course.addReview(new Review("The bad course"));
        course.addReview(new Review("The amazing course spring boot"));

        System.out.println(course);
        System.out.println(course.getReviews());

        appDAO.save(course);
    }

    private void deleteCourse(AppDAO appDAO) {
        int id = 10;
        appDAO.deleteCourseById(id);
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseById(id);

        course.setTitle("Java Master 2024");
        appDAO.update(course);
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        instructor.setLastName("TESTER");
        appDAO.update(instructor);
    }

    private void findInstructorJoinFetch(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);

        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        instructor.setCourses(courses);
        System.out.println(instructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("Madhu", "Patel", "patel@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube/muhamad", "badminton");
        instructor.setInstructorDetail(instructorDetail);

        Course courseJava = new Course("Java Master 2023");
        Course courseSpring = new Course("Spring Boot Master 2023");
        instructor.add(courseJava);
        instructor.add(courseSpring);

        appDAO.save(instructor);
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 3;
        appDAO.deleteInstructorDetailById(id);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 1;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println(instructorDetail);
        System.out.println(instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        appDAO.deleteInstructorById(id);
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        System.out.println(instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        /*
        Instructor instructor = new Instructor("Muhamad", "Iffat", "Iffat@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube/muhamad", "football");
         */
        Instructor instructor = new Instructor("Madhu", "Patel", "patel@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube/muhamad", "badminton");
        instructor.setInstructorDetail(instructorDetail);
        appDAO.save(instructor);
    }
}
