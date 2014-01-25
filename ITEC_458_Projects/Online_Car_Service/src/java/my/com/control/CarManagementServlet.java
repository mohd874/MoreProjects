/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.control;

import java.io.*;
import java.net.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;
import my.com.model.Car;
import my.com.model.User;

/**
 *
 * @author Saeed
 */
public class CarManagementServlet extends BaseServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";
        String action = request.getParameter("action");
        System.out.println("action: " + action);

        if ("registerCar".equalsIgnoreCase(action)) {
            Car car = validateCarRegistationInput(request);
            if (car != null) {
                url = "/show_cars.jsp";
                User user = (User) request.getSession().getAttribute("userBean");
                dbUtil.addCarForUser(car, user);
                Set<Car> userCars = dbUtil.getCarsForUser(user);
                request.setAttribute("cars", userCars);
                request.setAttribute("grandTotal", Car.getServiceGrandTotal(userCars));
            } else {
                url = "/register_car_for_service.jsp";
            }
        } else if ("showMyCars".equalsIgnoreCase(action)) {
            url = "/show_cars.jsp";
            User user = (User) request.getSession().getAttribute("userBean");
            Set<Car> userCars = dbUtil.getCarsForUser(user);
            request.setAttribute("cars", userCars);
            request.setAttribute("grandTotal", Car.getServiceGrandTotal(userCars));
        } else if ("showCarsForDate".equalsIgnoreCase(action)) {
            url = "/show_cars.jsp";
            Date date = getDateFromString(request.getParameter("serviceDate"));

            if (date == null) {
                date = new Date();
            }

            Set<Car> usersCars = dbUtil.getCarForTimePeriod(date);
            request.setAttribute("cars", usersCars);
            request.setAttribute("grandTotal", Car.getServiceGrandTotal(usersCars));
            request.setAttribute("serviceDate", getStringFromDate(date));
        }

        System.out.println("url: " + url);
        request.getRequestDispatcher(url).forward(request, response);
    }

    private Car validateCarRegistationInput(HttpServletRequest request) {
        Car car = null;

        String plateNumber = request.getParameter("plateNumber");
        String plateColor = request.getParameter("plateColor");
        String chasisNumber = request.getParameter("chasis");
        String manufacturer = request.getParameter("manufacturer");
        String model = request.getParameter("model");
        String yearOfManufacturing = request.getParameter("yearOfManufacturing");
        String service = request.getParameter("service");
        String serviceDateString = request.getParameter("serviceDate");

        Date serviceDate = getDateFromString(serviceDateString);

        Set<String> errors = new HashSet<String>();
        String errorString = "";
        if (plateNumber == null || "".equalsIgnoreCase(plateNumber)) {
            errorString = "Plate Number is required";
            errors.add(errorString);
        }
        if (plateColor == null || "".equalsIgnoreCase(plateColor)) {
            errorString = "Plate Color is required";
            errors.add(errorString);
        }
        if (chasisNumber == null || "".equalsIgnoreCase(chasisNumber)) {
            errorString = "Chasis Number is required";
            errors.add(errorString);
        }
        if (manufacturer == null || "".equalsIgnoreCase(manufacturer)) {
            errorString = "Manufacturer is required";
            errors.add(errorString);
        }
        if (model == null || "".equalsIgnoreCase(model)) {
            errorString = "Model is required";
            errors.add(errorString);
        }
        if (yearOfManufacturing == null || "".equalsIgnoreCase(yearOfManufacturing)) {
            errorString = "Year Of Manufacturing is required";
            errors.add(errorString);
        } else {
            try {
                Integer.parseInt(yearOfManufacturing);
            } catch (Exception e) {
                errorString = "Year Of Manufacturing is invalid";
                errors.add(errorString);
            }
        }
        if (service == null || "".equalsIgnoreCase(service)) {
            errorString = "Service Type is required";
            errors.add(errorString);
        }
        if (serviceDate == null) {
            errorString = "Service Date is required";
            errors.add(errorString);
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(serviceDate);

            System.out.println("(c.get(c.DAY_OF_WEEK) == (c.FRIDAY))--->" + (c.get(c.DAY_OF_WEEK) == (c.FRIDAY)));
            System.out.println("(c.get(c.DAY_OF_WEEK)--->" + c.get(c.DAY_OF_WEEK));
            System.out.println("c.FRIDAY--->" + c.FRIDAY);

            if (c.get(c.DAY_OF_WEEK) == (c.FRIDAY)) {
                errorString = "Cannot serve Cars on Friday";
                errors.add(errorString);
            } else {
                Set<Car> cars = dbUtil.getAllCars();
                System.out.println("cars.size--->" + cars.size());
                int carsCount = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String date1 = "";
                String date2 = "";
                for (Car car1 : cars) {
                    date1 = sdf.format(serviceDate);
                    date2 = sdf.format(car1.getServiceDate());
                    if (date1.equalsIgnoreCase(date2)) {
                        carsCount++;
                        System.out.println("count--->" + carsCount);
                    }
                    if (carsCount >= 10) {
                        System.out.println("count error--->" + carsCount);
                        errorString = "Cannot serve more than 10 cars per day";
                        errors.add(errorString);
                        break;
                    }
                }

            }
        }

        if (errors.size() > 0) {
            request.setAttribute("plateNumber", plateNumber);
            request.setAttribute("plateColor", plateColor);
            request.setAttribute("chasis", chasisNumber);
            request.setAttribute("manufacturer", manufacturer);
            request.setAttribute("model", model);
            request.setAttribute("yearOfManufacturing", yearOfManufacturing);
            request.setAttribute("service", service);
            request.setAttribute("serviceDate", serviceDateString);

            request.setAttribute("errors", errors);
            return null;
        } else {
            car = new Car(plateNumber, plateColor, chasisNumber, manufacturer,
                    model, Integer.parseInt(yearOfManufacturing), service,
                    serviceDate, ((User) request.getAttribute("userBean")));
        }

        return car;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
