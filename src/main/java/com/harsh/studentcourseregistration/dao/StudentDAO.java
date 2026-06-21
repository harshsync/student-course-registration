package com.harsh.studentcourseregistration.dao;
import com.harsh.studentcourseregistration.config.HibernateUtil;
import com.harsh.studentcourseregistration.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;



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
                Student s = getStudentById(id);
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
}
