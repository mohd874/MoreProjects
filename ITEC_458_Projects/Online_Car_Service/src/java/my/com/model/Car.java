/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.com.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name="cars")
public class Car {

    public static final String km5000  = "5000";
    public static final String km10000 = "10000";
    public static final String km20000 = "20000";
    public static final String km30000 = "30000";
    
    @Id @GeneratedValue @Column(name="id")
    private int id;
    
    @Column(name="plate_number")
    private String plateNumber;
    
    @Column(name="plate_color")
    private String plateColor;
    
    @Column(name="chasis_number")
    private String chasisNumber;
    
    @Column(name="manufacturer")
    private String manufacturer;
    
    @Column(name="model")
    private String model;
    
    @Column(name="year_of_manufacturing")
    private int yearOfManufacturing;
    
    @Column(name="service")
    private String service;
    
    @Column(name="service_date")
    @Temporal(TemporalType.DATE)
    private Date serviceDate;
    
    @ManyToOne(targetEntity=User.class)
    private User user;
    
    public float getServicePrice(){
        float price = 0f;
        
             if(km5000 .equalsIgnoreCase(service))price = 800;
        else if(km10000.equalsIgnoreCase(service))price = 1000;
        else if(km20000.equalsIgnoreCase(service))price = 1200;
        else if(km30000.equalsIgnoreCase(service))price = 1500;
        
        return price;
    }
    
    public static float getServiceGrandTotal(Set<Car> cars){
        float total = 0f;
        
        for (Car car : cars) {
                 if(km5000 .equalsIgnoreCase(car.getService()))total += 800;
            else if(km10000.equalsIgnoreCase(car.getService()))total += 1000;
            else if(km20000.equalsIgnoreCase(car.getService()))total += 1200;
            else if(km30000.equalsIgnoreCase(car.getService()))total += 1500;
        }

        return total;
    }
    
    public Car(){
        
    }
    
    public Car(String plateNumber, String plateColor, String chasisNumber, 
            String manufacturer, String model, int yearOfManufacturing,
            String service, Date serviceDate, User user){
        setPlateNumber(plateNumber);
        setPlateColor(plateColor);
        setChasisNumber(chasisNumber);
        setManufacturer(manufacturer);
        setModel(model);
        setYearOfManufacturing(yearOfManufacturing);
        setService(service);
        setServiceDate(serviceDate);
        setUser(user);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getChasisNumber() {
        return chasisNumber;
    }

    public void setChasisNumber(String chasisNumber) {
        this.chasisNumber = chasisNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public void setYearOfManufacturing(int yearOfManufacturing) {
        this.yearOfManufacturing = yearOfManufacturing;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
