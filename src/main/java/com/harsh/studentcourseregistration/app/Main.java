package com.harsh.studentcourseregistration.app;

import com.harsh.studentcourseregistration.config.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        System.out.println("SessionFactory created successfully!");

        HibernateUtil.shutdown();
    }
}