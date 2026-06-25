package com.harsh.studentcourseregistration.app;

import com.harsh.studentcourseregistration.config.HibernateUtil;
import com.harsh.studentcourseregistration.dao.CourseDAO;
import com.harsh.studentcourseregistration.dao.StudentDAO;
import com.harsh.studentcourseregistration.entity.Course;
import com.harsh.studentcourseregistration.entity.Student;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;
import java.sql.SQLOutput;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        System.out.println("SessionFactory created successfully!");


        Scanner ob = new Scanner(System.in);


        StudentDAO studentDao = new StudentDAO();
        CourseDAO courseDao = new CourseDAO();

        boolean running = true;
        while(running)
        {

            System.out.println("MAIN MENU");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");
            System.out.println();

            int ch = ob.nextInt();

            switch (ch) {
                case 1:
                    studentMenu(ob, studentDao);
                    break;

                case 2:
                    courseMenu(ob, courseDao);
                    break;

                case 3:
                    enrollmentMenu(ob);
                    break;


                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }



        HibernateUtil.shutdown();
    }

    public static void studentMenu(Scanner ob, StudentDAO dao)
    {
        boolean back = false;

        while(!back)
        {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View All Students");
            System.out.println("6. Back");

            int ch = ob.nextInt();
            Long id;
            Student student;

            switch(ch)
            {
                case 1 :

                    ob.nextLine();
                    System.out.println("Enter the first name");
                    String firstName = ob.nextLine();
                    System.out.println("Enter the last name");
                    String lastName = ob.nextLine();
                    System.out.println("Enter email :");
                    String email = ob.nextLine();
                    System.out.println("Enter the phone number -");
                    String phoneNumber = ob.nextLine();

                    System.out.println("Enter the Department - ");
                    String department = ob.nextLine();

                    LocalDate dob = null;

                    while(dob == null)
                    {
                        try
                        {
                            System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
                            dob = LocalDate.parse(ob.nextLine());
                        }
                        catch(Exception e)
                        {
                            System.out.println("Invalid date format. Try again.");
                        }
                    }

                    System.out.println("Enter your gender (Male/Female)");
                    String gender = ob.nextLine();

                    System.out.println("Enter the roll no.");
                    String rollNo = ob.nextLine();

                    System.out.println("Enter the admission year");
                    Integer admYear = ob.nextInt();

                    System.out.println("Enter the semster ");
                    Integer semester = ob.nextInt();

                    System.out.println("Enter the CGPA");
                    Double cgpa = ob.nextDouble();

                    student = new Student(firstName, lastName, email, phoneNumber, department, dob, gender, rollNo, admYear, semester, cgpa);
                    dao.saveStudent(student);
                    System.out.println("Student Added");

                    break;


                case 2 :

                    ob.nextLine();
                    System.out.println("Enter students' id ");
                    id = ob.nextLong();
                    student = dao.getStudentById(id);
                    if(student != null)
                    {
                        System.out.println(student);
                    }
                    else
                    {
                        System.out.println("Student not found");
                    }

                    break;

                case 3 :
                    ob.nextLine();
                    System.out.println("Enter student id");
                    id = ob.nextLong();
                    ob.nextLine();
                    System.out.println("Enter the new department");
                    String dept = ob.nextLine();
                    System.out.println("Enter the new CGPA");
                    Double cg = ob.nextDouble();
                    student = dao.getStudentById(id);
                    if(student != null)
                    {
                        student.setDepartment(dept);
                        student.setCgpa(cg);
                        dao.updateStudent(student);
                        System.out.println("Record Updated");
                    }
                    else
                    {
                        System.out.println("Student not found");
                    }

                    break;

                case 4 :
                    ob.nextLine();
                    System.out.println("Enter student id");
                    id = ob.nextLong();
                    student = dao.getStudentById(id);
                    if(student != null)
                    {
                        dao.deleteStudent(id);
                        System.out.println("Student deleted Successfully");
                    }
                    else
                    {
                        System.out.println("Student not found");
                    }
                    break;


                case 5 :
                    List<Student> students = dao.getAllStudents();

                    if(students != null && !students.isEmpty())
                    {
                        for(Student s : students)
                        {
                            System.out.println(s);
                        }
                    }
                    else
                    {
                        System.out.println("No students found");
                    }

                    break;

                case 6 :
                    back = true;
                    break;

                default :
                    System.out.println("Invalid Choice");
            }
        }
    }
}