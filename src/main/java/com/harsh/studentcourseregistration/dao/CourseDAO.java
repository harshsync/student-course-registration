package com.harsh.studentcourseregistration.dao;

import com.harsh.studentcourseregistration.config.HibernateUtil;
import com.harsh.studentcourseregistration.entity.Course;
import com.harsh.studentcourseregistration.entity.Student;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Set;


public class CourseDAO
{
    public void saveCourse(Course course)
    {
        Session session = null;
        Transaction transaction = null;

        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        finally {
            if(session != null)
                session.close();
        }
    }

    public Course getCourseById(Long id)
    {
        Session session = null;
        Course course = null;

        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            course = session.find(Course.class, id);
        }
        catch(Exception e)
        {
            course = null;
            e.printStackTrace();
        }
        finally {
            if(session != null)
                session.close();

        }
        return course;

    }

    public void updateCourse(Course course)
    {
        Session session = null;
        Transaction transaction = null;

        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(course);
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        finally {
            if(session != null)
                session.close();
        }
    }

    public void deleteCourse(Long id)
    {
        Session session = null;
        Transaction transaction = null;

        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Course course = session.find(Course.class, id);
            if(course != null)
            {
                session.remove(course);
            }
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        finally {
            if(session != null)
                session.close();
        }
    }

    public List<Course> getAllCourses()
    {
        Session session = null;

        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "From Course";
            Query query = session.createQuery(hql);
            return query.getResultList();
        }
        catch (Exception e)
        {
            return null;
        }
        finally {
            if(session != null)
            {
                session.close();
            }
        }
    }

    public Set<Student> getStudentsOfCourse(Long courseId)
    {
        Session session = null;

        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            Course course = session.find(Course.class, courseId);
            if(course != null)
                return course.getStudents();
            return null;
        } catch (Exception e) {
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
}
