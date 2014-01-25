/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Saeed
 */
public class HibernateUtil {

        private static EntityManagerFactory emf = null;
        
        static {
            emf = Persistence.createEntityManagerFactory("mainapp");
        }
        
        private HibernateUtil(){
            
        }
        
        public static EntityManagerFactory getEntityManagerFactory(){
            return emf;
        }
        
        public static EntityManager getEntityManager(){
            return getEntityManagerFactory().createEntityManager();
        }
        
        public static void main(String[] args) {
            System.out.println("EntityManagerFactory is null: "+(emf==null));
            System.out.println("EntityManager is null: "+(emf.createEntityManager()==null));
        }

}
