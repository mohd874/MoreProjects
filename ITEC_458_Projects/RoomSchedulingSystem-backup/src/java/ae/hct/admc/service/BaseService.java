/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.hct.admc.service;

import ae.hct.admc.domain.BaseEntity;
import ae.hct.admc.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Saeed
 */
class BaseService {

    private static Session session;
    
    protected static void saveOrUpdate(BaseEntity entity){
        session = beginTransaction();
        if(entity.getCreateDate() == null)entity.setCreateDate(new Date());
        session.save(entity);
        endTransaction(session);
    }
    
    protected static Session beginTransaction() {
        Session session = HibernateUtil.getAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        return session;
    }

    protected static void endTransaction(Session session) {
        if(session != null && session.isOpen())
            session.close();
    }
}
