package com.harsh.studentcourseregistration.dao;
import com.harsh.studentcourseregistration.config.HibernateUtil;
import com.harsh.studentcourseregistration.entity.Course;
import com.harsh.studentcourseregistration.entity.Student;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StudentDAO
{


    public void saveStudent(Student student)
    {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();

            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

        public Student getStudentById(Long id)
        {
            Session session = null;
            Student student = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                student = session.find(Student.class, id);
            }
            catch (Exception e)
            {
                student =  null;
            }
            finally {
                if(session != null)
                {
                    session.close();
                }

            }
            return student;

        }

        public void updateStudent(Student s)
        {
            Session session = null;
            Transaction transaction = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                if(s != null) {
                    session.merge(s);
                    transaction.commit();
                }
            }
            catch (Exception e) {
                if (transaction != null)
                    transaction.rollback();

                e.printStackTrace();
            }
            finally {
                if (session != null) {
                    session.close();
                }
            }
        }

        public void deleteStudent(long id)
        {
            Session session = null;
            Transaction transaction = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                Student s = session.find(Student.class, id);
                if(s != null)
                {
                    session.remove(s);
                    transaction.commit();
                }
            }
            catch (Exception e)
            {
                if(transaction != null)
                {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            finally {
                if(session != null)
                {
                    session.close();
                }
            }
        }

        public List<Student> getAllStudents()
        {
            Session session = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                String q = "FROM Student";
                Query query = session.createQuery(q);
                if(query != null)
                 return query.getResultList();
                else
                    return null;
            }
            catch (Exception e)
            {
                return null;
            }
            finally
            {
                if(session != null)
                {
                    session.close();
                }
            }
        }

        public Set<Course> getCoursesOfStudent(Long studentId)
        {
            Session session = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                Student student = session.find(Student.class, studentId);
                if(student != null)
                    return student.getCourses();
                return null;

            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
            finally
            {
                if(session != null)
                {
                    session.close();
                }
            }
        }

        public void unenrollStudent(Long studentId, Long courseId)
        {
            Session session = null;
            Transaction transaction = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                Student student = session.find(Student.class, studentId);
                Course course = session.find(Course.class, courseId);
                if(student != null && course != null)
                {
                    student.getCourses().remove(course);

                    session.merge(student);

                    transaction.commit();
                }
            }
            catch (Exception e)
            {
                if(transaction != null)
                {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            finally {
                if(session != null)
                {
                    session.close();
                }
            }
        }

}
