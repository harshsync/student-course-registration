package com.harsh.studentcourseregistration.app;

import com.harsh.studentcourseregistration.config.HibernateUtil;
import com.harsh.studentcourseregistration.dao.StudentDAO;
import com.harsh.studentcourseregistration.entity.Student;
import org.hibernate.SessionFactory;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        System.out.println("SessionFactory created successfully!");



        Student s1 = new Student(
                "Harsh",
                "Kumar",
                "harsh.kumar23@gmail.com",
                "9876543210",
                "Computer Science and Engineering",
                LocalDate.of(2003, 7, 15),
                "Male",
                "CSE2023001",
                2023,
                6,
                8.72
        );
        StudentDAO dao = new StudentDAO();
        dao.saveStudent(s1);
        System.out.println(s1);

        HibernateUtil.shutdown();
    }
}