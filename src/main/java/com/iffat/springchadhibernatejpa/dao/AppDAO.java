package com.iffat.springchadhibernatejpa.dao;

import com.iffat.springchadhibernatejpa.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
