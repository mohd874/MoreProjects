/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.hct.admc.service;

import ae.hct.admc.domain.BaseEntity;
import ae.hct.admc.domain.Block;
import ae.hct.admc.domain.Course;
import ae.hct.admc.domain.Period;
import ae.hct.admc.domain.Room;
import ae.hct.admc.domain.RoomClassScedule;
import ae.hct.admc.domain.RoomType;
import ae.hct.admc.domain.Semester;
import ae.hct.admc.domain.User;
import ae.hct.admc.util.DateTimeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Saeed
 */
public class HibernateService extends BaseService {

    private static Logger LOG = Logger.getLogger(HibernateService.class);

    
    public static List<User> getAllUsers() {
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        String queryString = "from User";
        org.hibernate.Query query = session.createQuery(queryString);
//        Query query = manager.createQuery(queryString);

        List<User> users = query.list();
//        List<User> users = query.getResultList();
//        endTransaction(session);
        return users;
    }
    
    public static List<Room> getAllRooms() {
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        String queryString = "from Room";
        org.hibernate.Query query = session.createQuery(queryString);

        List<Room> rooms = query.list();
        endTransaction(session);
        return rooms;
    }
    
    public static List<Period> getAllPeriods(){
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        String queryString = "from Period";
        org.hibernate.Query query = session.createQuery(queryString);

        List<Period> rooms = query.list();
        endTransaction(session);
        return rooms;
    }
    
    public static List<RoomClassScedule> getClassSchedule(Period period, 
            Semester semester, int week, Room room){
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(semester.getDateFrom());
//        cal.add(cal.DAY_OF_YEAR, (week-1)*7);
//        
//        Date newDate = cal.getTime();
//        Date from = DateTimeUtil.getWeekStartDate(newDate);
//        Date to = DateTimeUtil.getWeekEndDate(newDate);
        
        Session session = beginTransaction();
        String queryString = "from RoomClassScedule rcs where rcs.semester = " +
                ":semester and rcs.period = :period and rcs.semesterWeek = :week " +
                "and rcs.room = :room order by rcs.dayOfWeek asc";
        org.hibernate.Query query = session.createQuery(queryString);
        query.setParameter("period", period);
        query.setParameter("semester", semester);
        query.setParameter("week", week);
        query.setParameter("room", room);
        List<RoomClassScedule> schedule = query.list();
        endTransaction(session);
        
        return schedule;
    }
    
    public static List<RoomClassScedule> getPendingClassSchedule(){
        
        Session session = beginTransaction();
        String pendingParam = RoomClassScedule.PENDING_STATUS;
        String queryString = "from RoomClassScedule rcs where " +
                "rcs.reservationStatus = :pending";
        org.hibernate.Query query = session.createQuery(queryString);
        query.setParameter("pending", pendingParam);
        List<RoomClassScedule> schedule = query.list();
        endTransaction(session);
        
        return schedule;
    }
    
    public static Semester getCurrentSemester(){
        
        Date now = new Date();
        Session session = beginTransaction();
        String queryString = "from Semester s where s.dateFrom <= :now " +
                "and s.dateTo >= :now";
        org.hibernate.Query query = session.createQuery(queryString);
        query.setParameter("now", now);
        List<Semester> semesters = query.list();
        endTransaction(session);
        if(semesters != null && semesters.size()>0){
            return semesters.get(0);
        }
        return null;
    }
    
    public static Room getRoomById(int roomId){
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        String queryString = "from Room r where r.id = :id";
        org.hibernate.Query query = session.createQuery(queryString);
        query.setParameter("id", roomId);
        
        List<Room> rooms = query.list();
        endTransaction(session);
        if(rooms != null && rooms.size()>0){
            return rooms.get(0);
        }
        return null;
    }
    
    public static Room getRoomByName(String roomName){
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        String queryString = "from Room r where r.name = :name";
        org.hibernate.Query query = session.createQuery(queryString);
        query.setParameter("name", roomName);
        
        List<Room> rooms = query.list();
        endTransaction(session);
        if(rooms != null && rooms.size()>0){
            return rooms.get(0);
        }
        return null;
    }
    
    public static List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<Course>();
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        String queryString = "from Course";
        org.hibernate.Query query = session.createQuery(queryString);
        
        courses = query.list();
        endTransaction(session);
        
        return courses;
    }

    public static List<RoomType> getAllRoomTypes(){
        List<RoomType> types = new ArrayList<RoomType>();
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        String queryString = "from RoomType";
        org.hibernate.Query query = session.createQuery(queryString);
        
        types = query.list();
        endTransaction(session);
        
        return types;
    }
    
    public static List<Block> getAllBlocks(){
        List<Block> blocks = new ArrayList<Block>();
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        String queryString = "from Block";
        org.hibernate.Query query = session.createQuery(queryString);
        
        blocks = query.list();
        endTransaction(session);
        
        return blocks;
    }
    
    public static Semester getSemesterById(int semesterId) {
        
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        org.hibernate.Query query = session.getNamedQuery("Semester.getSemesterById");
        query.setParameter("id", semesterId);
        
        List<Semester> list = query.list();
        Semester semester = null;
        if(list != null && list.size() > 0){
            semester = list.get(0);
        }
        endTransaction(session);
        return semester;
    }
    
    public static BaseEntity getEntityById(Class clazz, int id) {
        
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        BaseEntity entity = (BaseEntity)session.get(clazz, id);
        
        endTransaction(session);
        return entity;
    }

    public static void saveEntity(BaseEntity entity, User createUser) {
        if(entity.getCreateUser() == null){
            entity.setCreateUser(createUser);
        }
        saveEntity(entity);
    }
    
    public static void saveEntity(BaseEntity entity) {
        Session session = beginTransaction();
//        EntityManager manager = HibernateUtil.getEntityManager();
        if(entity.getCreateDate() == null){
            entity.setCreateDate(new Date());
        }
        if(entity.getRecordStatus() == null){
            entity.setRecordStatus(BaseEntity.RecordStatus.Active);
        }
        if(entity.getId() == null){
            session.save(entity);
        }else{
            session.update(entity);
        }
        
//        session.saveOrUpdate(entity);
//        session.persist(entity);
        LOG.debug("about to save entity "+session.getEntityName(entity));
        session.getTransaction().commit();
        LOG.debug("entity was saved with id: "+entity.getId());
        endTransaction(session);
    }
    
    public static void deleteEntity(BaseEntity entity) {
//        entity.setRecordStatus(BaseEntity.RecordStatus.Deleted);
//        saveEntity(entity);
        Session session = beginTransaction();
        session.update(entity);
        LOG.debug("about to delete entity "+session.getEntityName(entity));
        session.delete(entity);
        session.getTransaction().commit();
        
        endTransaction(session);
    }
    
}
