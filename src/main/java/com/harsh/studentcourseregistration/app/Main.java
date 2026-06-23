package com.harsh.studentcourseregistration.app;

import com.harsh.studentcourseregistration.config.HibernateUtil;
import com.harsh.studentcourseregistration.dao.CourseDAO;
import com.harsh.studentcourseregistration.dao.StudentDAO;
import com.harsh.studentcourseregistration.entity.Course;
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
//                "harsh.test01@gmail.com",
//                "9876543210",
//                "Computer Science and Engineering",
//                LocalDate.of(2003, 7, 15),
//                "Male",
//                "CSE2023001",
//                2023,
//                6,
//                8.72
//        );
//        Course c1 = new Course(
//                "CS301",
//                "Database Management Systems",
//                4,
//                "Computer Science and Engineering",
//                6,
//                60,
//                "Dr. Rajesh Sharma",
//                5500.0
//        );
       StudentDAO  studentdao = new StudentDAO();
       CourseDAO coursedao = new CourseDAO();

//       studentdao.saveStudent(s1);
//       coursedao.saveCourse(c1);

       Course course = coursedao.getCourseById(1l);
        Student student = studentdao.getStudentById(13L);

       if(student != null && course != null)
       {
           student.getCourses().add(course);
           studentdao.updateStudent(student);
           System.out.println("Enrollment Successfully");
       }



        HibernateUtil.shutdown();
    }
}