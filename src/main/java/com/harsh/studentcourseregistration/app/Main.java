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

        Student s2 = new Student(
                "Aman",
                "Sharma",
                "aman.sharma23@gmail.com",
                "9123456789",
                "Information Technology",
                LocalDate.of(2002, 11, 8),
                "Male",
                "IT2023002",
                2023,
                6,
                9.15
        );

        Student s3 = new Student(
                "Priya",
                "Singh",
                "priya.singh23@gmail.com",
                "9988776655",
                "Computer Science and Engineering",
                LocalDate.of(2004, 3, 21),
                "Female",
                "CSE2023003",
                2023,
                4,
                8.94
        );

        Student s4 = new Student(
                "Rahul",
                "Verma",
                "rahul.verma23@gmail.com",
                "9012345678",
                "Electronics and Communication",
                LocalDate.of(2002, 9, 10),
                "Male",
                "ECE2023004",
                2023,
                8,
                7.68
        );

        Student s5 = new Student(
                "Sneha",
                "Patel",
                "sneha.patel23@gmail.com",
                "9090909090",
                "Mechanical Engineering",
                LocalDate.of(2003, 1, 30),
                "Female",
                "ME2023005",
                2023,
                6,
                8.21
        );
        StudentDAO dao = new StudentDAO();
        dao.saveStudent(s1);
        dao.saveStudent(s2);
        dao.saveStudent(s3);
        dao.saveStudent(s4);
        dao.saveStudent(s5);

        System.out.println(dao.getAllStudents());

        HibernateUtil.shutdown();
    }
}