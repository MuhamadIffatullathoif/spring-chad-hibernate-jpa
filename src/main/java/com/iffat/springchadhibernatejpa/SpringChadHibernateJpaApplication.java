package com.iffat.springchadhibernatejpa;

import com.iffat.springchadhibernatejpa.dao.AppDAO;
import com.iffat.springchadhibernatejpa.entity.Course;
import com.iffat.springchadhibernatejpa.entity.Instructor;
import com.iffat.springchadhibernatejpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            findInstructorWithCourses(appDAO);
        };
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
        int id = 2;
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
