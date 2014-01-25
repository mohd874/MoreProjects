/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import my.com.model.Car;
import my.com.model.User;
import my.com.util.HibernateUtil;

/**
 *
 * @author Saeed
 */
public class DatabaseUtil {

    public DatabaseUtil() {
    }

    public EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager();
    }
    
    public void saveOrUpdateUser(User user){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if(user.getId() == 0){
            em.persist(user);
        }else{
            em.merge(user);
        }
        tx.commit();
        em.close();
    }
    
    public void saveOrUpdateCar(Car car){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if(car.getId() == 0){
            em.persist(car);
        }else{
            em.merge(car);
        }
        tx.commit();
        em.close();
    }
    
    public List<User> getAllUsers() {
        return getEntityManager().createQuery("from User").getResultList();
    }

    public List<User> getInactiveUsers() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("from User u where u.active = 'no'");
        return query.getResultList();
    }

    public User getUserById(int user_id) {
        return getEntityManager().find(User.class, user_id);
    }

    public User getUserByUserName(String userName) {
        try{
            return (User)getEntityManager().createQuery("from User u where u.userName = :userName")
                    .setParameter("userName", userName).getResultList().get(0);
        }catch(IndexOutOfBoundsException ex){
            System.out.println("no users where found");
            return null;
        }catch(Exception ex){
            System.out.println("Exception occured in getUserByUserName: "+ex.getMessage());
            return null;
        }
    }

    public void addUser(User user) throws SQLException {
        saveOrUpdateUser(user);
    }

    public void activateUsers(int[] selectedUsers) throws SQLException{
        for (int i = 0; i < selectedUsers.length; i++) {
            activateUser(selectedUsers[i]);
        }
    }
    
    private boolean activateUser(int userId) throws SQLException{
        boolean status = true;
        EntityManager em = getEntityManager();
        User user = getUserById(userId);
        user.setActive("yes");
        saveOrUpdateUser(user);
        return status;
    }

    public Set<Car> getAllCars() {
        Set<Car> cars = new HashSet<Car>(getEntityManager().createQuery("from Car c").getResultList());
        return cars;
    }

    public void addCarForUser(Car car, User user){
        car.setUser(user);
        saveOrUpdateCar(car);
    }

    private Car getCarByPlateNumber(String plateNumber) {
        try{
        return (Car) getEntityManager().createQuery("from Car c where c.plateNumber")
                .getResultList().get(0);
        }catch(IndexOutOfBoundsException ex){
            System.out.println("no users where found");
            return null;
        }catch(Exception ex){
            System.out.println("Exception occured in getUserByUserName: "+ex.getMessage());
            return null;
        }
    }

    public Set<Car> getCarForTimePeriod(Date date) {
        Set<Car> cars = new HashSet<Car>();
        cars.addAll(getEntityManager().createQuery("from Car c WHERE c.serviceDate = :date")
                .setParameter("date", date).getResultList());
        return  cars;
    }

    public Set<Car> getCarsForUser(User user) {
        Set<Car> cars = new HashSet<Car>();
        cars.addAll(getEntityManager().createQuery("from Car c where c.user = :user")
                .setParameter("user", user).getResultList());
        return cars;
    }

//    private Car getCarInformationFromResultSet(ResultSet rs) throws SQLException {
//        int id = rs.getInt("id");
//        String plateNumber = rs.getString("plate_number");
//        String plateColor = rs.getString("plate_color");
//        String manufacturer = rs.getString("manufacturer");
//        String model = rs.getString("model");
//        Date serviceDate = rs.getDate("service_date");
//        String service = rs.getString("service");
//        int year = rs.getInt("year");
//        String chasis = rs.getString("chasiss_no");
//        int user_id = rs.getInt("user_id");
//
//        return new Car(plateNumber, plateColor, plateNumber, manufacturer, model,
//                year, service, serviceDate, user_id);
//    }
    
    // <editor-fold>
    /*
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<User>();
        PreparedStatement stmt = null;
        try {
            String queryString = "SELECT * FROM users";
            stmt = connection.prepareStatement(queryString);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("user_name");
                String pass = rs.getString("pass");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String gender = rs.getString("gender");
                String telephone = rs.getString("telephone");
                String type = rs.getString("type");
                String active = rs.getString("active");
                String licene = rs.getString("licene_no");
                String email = rs.getString("email");

                User user = new User(id, name, username, pass, dateOfBirth, gender,
                        type, active, telephone, licene, email);

                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public List<User> getInactiveUsers() {

        List<User> users = new ArrayList<User>();
        PreparedStatement stmt = null;
        try {
            String queryString = "SELECT * FROM users u WHERE u.active = 'no'";
            stmt = connection.prepareStatement(queryString);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("user_name");
                String pass = rs.getString("pass");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String gender = rs.getString("gender");
                String telephone = rs.getString("telephone");
                String type = rs.getString("type");
                String active = rs.getString("active");
                String licene = rs.getString("licene_no");
                String email = rs.getString("email");

                User user = new User(id, name, username, pass, dateOfBirth, gender,
                        type, active, telephone, licene, email);

                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public User getUserById(int user_id) {
        User user = null;
        PreparedStatement stmt = null;
        try {
            String queryString = "SELECT * FROM users u WHERE u.id = ?";
            stmt = connection.prepareStatement(queryString);
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("user_name");
                String pass = rs.getString("pass");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String gender = rs.getString("gender");
                String telephone = rs.getString("telephone");
                String type = rs.getString("type");
                String active = rs.getString("active");
                String licene = rs.getString("licene_no");
                String email = rs.getString("email");

                user = new User(id, name, username, pass, dateOfBirth, gender,
                        type, active, telephone, licene, email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public User getUserByUserName(String userName) {
        User user = null;
        PreparedStatement stmt = null;
        try {
            String queryString = "SELECT * FROM users u WHERE u.user_name = ?";
            stmt = connection.prepareStatement(queryString);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("user_name");
                String pass = rs.getString("pass");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String gender = rs.getString("gender");
                String telephone = rs.getString("telephone");
                String type = rs.getString("type");
                String active = rs.getString("active");
                String licene = rs.getString("licene_no");
                String email = rs.getString("email");

                user = new User(id, name, username, pass, dateOfBirth, gender,
                        type, active, telephone, licene, email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public int addUser(User user) throws SQLException {
        int newUserId = 0;

        PreparedStatement stmt = null;
        try {
            String queryString = "INSERT INTO users (name, user_name, pass, " +
                    "date_of_birth, gender, telephone, type, active, licene_no," +
                    "email) VALUES (?,?,?,?,?,?,?,?,?,?)";
            stmt = connection.prepareStatement(queryString);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getPassword());
            stmt.setDate(4, new java.sql.Date(user.getDateOfBirth().getTime()));
            stmt.setString(5, user.getGender());
            stmt.setString(6, user.getPhoneNumber());
            stmt.setString(7, user.getType());
            stmt.setString(8, user.getActive());
            stmt.setString(9, user.getLicenseNumber());
            stmt.setString(10, user.getEmail());

            stmt.executeUpdate();

            newUserId = getUserByUserName(user.getUserName()).getId();
        } catch (SQLException sqle) {
            throw sqle;
        } finally {
            safeClose(stmt);
        }


        return newUserId;
    }

    public void activateUsers(int[] selectedUsers) throws SQLException{
        for (int i = 0; i < selectedUsers.length; i++) {
            activateUser(selectedUsers[i]);
        }

    }
    
    private boolean activateUser(int userId) throws SQLException{
        PreparedStatement stmt = null;
        boolean status = true;
        
        try {
            String queryString = "UPDATE users u SET u.active = 'yes' WHERE u.id = ?";
            stmt = connection.prepareStatement(queryString);
            stmt.setInt(1, userId);
            System.out.println("queryString: "+queryString);
            System.out.println("userId: "+userId);
            int count = stmt.executeUpdate();
            System.out.println("count: "+count);
            if(count != 0){
                status = true;
            }else{
                status = false;
            }
        } catch (SQLException sqle) {
            throw sqle;
        } finally {
            safeClose(stmt);
        }
        
        return status;
    }

    public Set<Car> getAllCars() {
        Car car = null;
        Set<Car> cars = new HashSet<Car>();
        PreparedStatement stmt = null;
        try {
            String queryString = "SELECT * FROM cars";
            stmt = connection.prepareStatement(queryString);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cars.add(getCarInformationFromResultSet(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cars;
    }

    public int addCarForUser(Car car, User user) throws SQLException {
        int newCarId = 0;

        PreparedStatement stmt = null;
        try {
            String queryString = "INSERT INTO cars (plate_number, plate_color," +
                    " service_date, chasiss_no, manufacturer, model, year, service, " +
                    " user_id) VALUES (?,?,?,?,?,?,?,?,?)";
            stmt = connection.prepareStatement(queryString);
            stmt.setString(1, car.getPlateNumber());
            stmt.setString(2, car.getPlateColor());
            stmt.setDate(3, new java.sql.Date(car.getServiceDate().getTime()));
            stmt.setString(4, car.getChasisNumber());
            stmt.setString(5, car.getManufacturer());
            stmt.setString(6, car.getModel());
            stmt.setInt(7, car.getYearOfManufacturing());
            stmt.setString(8, car.getService());
            stmt.setInt(9, user.getId());


            stmt.executeUpdate();

            newCarId = getCarByPlateNumber(car.getPlateNumber()).getId();
        } catch (SQLException sqle) {
            throw sqle;
        } finally {
            safeClose(stmt);
        }


        return newCarId;
    }

    private Car getCarByPlateNumber(String plateNumber) {
        Car car = null;
        PreparedStatement stmt = null;
        try {
            String queryString = "SELECT * FROM cars c WHERE c.plate_number = ?";
            stmt = connection.prepareStatement(queryString);
            stmt.setString(1, plateNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String plateColor = rs.getString("plate_color");
                String manufacturer = rs.getString("manufacturer");
                String model = rs.getString("model");
                Date serviceDate = rs.getDate("service_date");
                String service = rs.getString("service");
                int year = rs.getInt("year");
                String chasis = rs.getString("chasiss_no");

                car = getCarInformationFromResultSet(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return car;
    }

    public Set<Car> getCarForTimePeriod(Date date) {
        PreparedStatement stmt = null;
        Set<Car> cars = new HashSet<Car>();
        try {
            String queryString = "SELECT * FROM cars c WHERE c.service_date = ?";
            stmt = connection.prepareStatement(queryString);
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cars.add(getCarInformationFromResultSet(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cars;
    }

    public Set<Car> getCarsForUser(User user) {
        Car car = null;
        Set<Car> cars = new HashSet<Car>();
        PreparedStatement stmt = null;
        try {
            String queryString = "SELECT * FROM cars u WHERE u.user_id = ?";
            stmt = connection.prepareStatement(queryString);
            stmt.setInt(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cars.add(getCarInformationFromResultSet(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cars;
    }

    private void safeClose(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException sqle) {
        //ignore
        }
    }

    private Car getCarInformationFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String plateNumber = rs.getString("plate_number");
        String plateColor = rs.getString("plate_color");
        String manufacturer = rs.getString("manufacturer");
        String model = rs.getString("model");
        Date serviceDate = rs.getDate("service_date");
        String service = rs.getString("service");
        int year = rs.getInt("year");
        String chasis = rs.getString("chasiss_no");
        int user_id = rs.getInt("user_id");

        return new Car(plateNumber, plateColor, plateNumber, manufacturer, model,
                year, service, serviceDate, user_id);
    }
     */
    //</editor-fold>
}
