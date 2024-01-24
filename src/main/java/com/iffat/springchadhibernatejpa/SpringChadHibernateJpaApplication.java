package com.iffat.springchadhibernatejpa;

import com.iffat.springchadhibernatejpa.dao.AppDAO;
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
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("Muhamad", "Iffat", "Iffat@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube/muhamad", "football");
        instructor.setInstructorDetail(instructorDetail);
        appDAO.save(instructor);
    }
}
