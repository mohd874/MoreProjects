package com.me.control;

import com.me.db.Customer;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.apache.log4j.Logger;

/**
 * Base service for all JPA-based service implementations. Provides methods for
 * entity CRUD operations and writes audit data for CUD.
 * 
 */
public abstract class BaseService {

    static Logger LOG = Logger.getLogger(BaseService.class);
    /**
     * TODO Extract file name to Spring app context XML
     */
    protected static EntityManager entityManager;
    private static Properties nativeQueryStrings;
    
    @PersistenceUnit(unitName = "HibernateWithJPAPU")
    private static EntityManagerFactory emf;
    
    static{
        emf = Persistence.createEntityManagerFactory("HibernateWithJPAPU");
        entityManager = emf.createEntityManager();
    }
    
    /**
     * Spring-injected JPA entity manager
     * 
     * @param entityManager
     */
    @PersistenceContext
    public final void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    private static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Create a named native SQL query object from the query strings read in
     * from the properties file on the classpath (see static initializer). The
     * convention here is that the SqlResultSetMapping should have the same name
     * as the query string key in the properties file.
     * 
     * @param queryName
     *            the name of the native query
     * @return the native query object
     */
    protected Query createNamedNativeQuery(String queryName) {

        String queryString = nativeQueryStrings.getProperty(queryName);
        return entityManager.createNativeQuery(queryString, queryName);
    }

    public static List<Customer> getCustomers(){
        
        Query query = getEntityManager().createQuery("from Customer");
        
        return query.getResultList();
    }
    
}
