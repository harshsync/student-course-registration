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



//        Student s1 = new Student(
//                "Harsh",
//                "Kumar",
//                "harsh.kumar23@gmail.com",
//                "9876543210",
//                "Computer Science and Engineering",
//                LocalDate.of(2003, 7, 15),
//                "Male",
//                "CSE2023001",
//                2023,
//                6,
//                8.72
//        );
        StudentDAO dao = new StudentDAO();
//        dao.saveStudent(s1);
//        System.out.println(s1);

//        Student s2 = dao.getStudentById((long) 1);
//        if(s2 != null)
//        System.out.println(s2);
//        else
//        System.out.println("Null pointing");
        Student s = dao.getStudentById((long)1);
        if(s != null)
        {
            s.setCgpa(7.9);
            s.setDepartment("Ed Tech");
            dao.updateStudent(s);
            System.out.println(s);
        }
        else
            System.out.println("Null");

        HibernateUtil.shutdown();
    }
}