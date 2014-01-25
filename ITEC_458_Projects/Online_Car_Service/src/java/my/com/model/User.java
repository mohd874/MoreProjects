/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.com.model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name="users")
public class User {

    public static final String TYPE_USER = "user";
    public static final String TYPE_ADMIN = "admin";
    
    @Id @GeneratedValue @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="user_name")
    private String userName;
    
    @Column(name="password")
    private String password;
    
    @Column(name="date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Column(name="gender")
    private String gender;
    
    @Column(name="type")
    private String type;
    
    @Column(name="active")
    private String active;
    
    @Column(name="phone_number")
    private String phoneNumber;
    
    @Column(name="license_number")
    private String licenseNumber;
    
    @Column(name="email")
    private String email;
    
    public User(){
        setActive("no");
        setType(TYPE_USER);
    }
    
    public User(int id, String name, String userName, String password, Date dateOfBirth,
            String gender, String type, String active, String phoneNumber, 
            String licenseNumber, String email){
        setId(id);
        setName(name);
        setUserName(userName);
        setPassword(password);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setType(type);
        setActive(active);
        setPhoneNumber(phoneNumber);
        setLicenseNumber(licenseNumber);
        setEmail(email);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
