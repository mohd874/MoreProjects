package com.me;

import com.me.model.Course;
import com.me.model.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mainapp2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student student = new Student("H000010", "Ali Ahmed");
        Course c1 = new Course("ITEC100", "Information Technology I");
        Course c2 = new Course("ITEC150", "Programming Fundemantals");
        
        c1.setStudent(student);
        c2.setStudent(student);
        em.persist(student);
        em.persist(c1);
        em.persist(c2);
        
        tx.commit();
        em.close();
        
        //shutting down the application
        emf.close();
    }
}
