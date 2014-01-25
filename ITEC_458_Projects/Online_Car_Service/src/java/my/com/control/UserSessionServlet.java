/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.control;

import java.io.*;
import java.net.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import my.com.mail.MailUtilLocal;
import my.com.model.User;

/**
 *
 * @author Saeed
 */
public class UserSessionServlet extends BaseServlet {

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

        if ("register".equalsIgnoreCase(action)) {
            if (validateUserRegistrationInput(request)) {
                url = "/registration_confirmation.jsp";
                String name = request.getParameter("name");
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                String dateOfBirthString = request.getParameter("dob");//dd-mm-yyyy
                String licenseNumber = request.getParameter("license");
                String telephone = request.getParameter("telephone");
                String gender = request.getParameter("gender");
                String email = request.getParameter("email");

                Calendar c = Calendar.getInstance();
                StringTokenizer st = new StringTokenizer(dateOfBirthString, "-");

                c.set(c.DAY_OF_MONTH, Integer.parseInt(st.nextToken()));
                c.set(c.MONTH, Integer.parseInt(st.nextToken()));
                c.set(c.YEAR, Integer.parseInt(st.nextToken()));

                Date dateOfBirth = c.getTime();
                System.out.println("dateOfBirth: " + dateOfBirth);
                User user = new User();
                user.setName(name);
                user.setUserName(userName);
                user.setPassword(password);
                user.setDateOfBirth(dateOfBirth);
                user.setLicenseNumber(licenseNumber);
                user.setPhoneNumber(telephone);
                user.setGender(gender);
                user.setEmail(email);

                try {
                    dbUtil.addUser(user);
                    System.out.println("New User ID: "+user.getId());
//                    setUserSession(user, request);
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            } else {
                url = "/register.jsp";
            }
        } else if ("login".equalsIgnoreCase(action)) {
            User user = validateUserLoginInput(request);
            if (user != null) {
                Logger.getLogger(UserSessionServlet.class.getName()).log(Level.FINE, null, "Login Seccess");
                url = "main.jsp";
                setUserSession(user, request);
            } else {
                Logger.getLogger(UserSessionServlet.class.getName()).log(Level.FINE, null, "Login Failed");
                url = "/login.jsp";
            }
        } else if ("logout".equalsIgnoreCase(action)) {
            url = "main.jsp";
            setUserSession(null, request);
        } else if ("activateUsers".equalsIgnoreCase(action)) {
            url = "users_to_activate.jsp";

            String[] selectedUsers = request.getParameterValues("selectedUsers");

            if (selectedUsers != null && selectedUsers.length > 0) {
                int[] selectedUsersIds = new int[selectedUsers.length];
                System.out.println("selectedUsers.length--->" + selectedUsers.length);

                for (int i = 0; i < selectedUsers.length; i++) {
                    try {
                        selectedUsersIds[i] = Integer.parseInt(selectedUsers[i]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    dbUtil.activateUsers(selectedUsersIds);
                    User u = null;
                    String messageBody = "Your account has been activated";
                    for (int i = 0; i < selectedUsersIds.length; i++) {
                        u = dbUtil.getUserById(selectedUsersIds[i]);
                        try{
                        MailUtilLocal.sendMail(u.getEmail(), "admin@onlinecarservice.com",
                                "Account activitaion", messageBody, false);
                        }catch(MessagingException ex){
                            ex.printStackTrace();
                        }
                    }

                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
                System.out.println("selectedUsersIds.length--->" + selectedUsersIds.length);
            }

            List<User> users = dbUtil.getInactiveUsers();
            System.out.println("users.size--->" + users.size());
            request.setAttribute("users", users);
        }
        System.out.println("url: " + url);
        request.getRequestDispatcher(url).forward(request, response);
    }

    private void setUserSession(User user, HttpServletRequest request) {
        request.getSession().setAttribute(USER_BEAN_STRING, user);
    }

    private User validateUserLoginInput(HttpServletRequest request) {
//        boolean status = true;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Set<String> errors = new HashSet<String>();
        String errorString = "";
        if (username == null || "".equalsIgnoreCase(username)) {
            errorString = "Please provide your user name";
            errors.add(errorString);
//            status = false;
        }
        if (password == null || "".equalsIgnoreCase(password)) {
            errorString = "Please provide your password";
            errors.add(errorString);
//            status = false;
        }

        User user = dbUtil.getUserByUserName(username);

        if (user == null) {
            errorString = "Either your user name or password in wrong. please " +
                    "check your user name and password and try again.";
            errors.add(errorString);
//            status = false;
        } else {
            if (!user.getPassword().equalsIgnoreCase(password)) {
                errorString = "Either your user name or password in wrong. please " +
                        "check your user name and password and try again.";
                errors.add(errorString);
//                status = false;
            }
        }

//        if(!status){
        if (user == null) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("errors", errors);
        } else {
            if ("no".equalsIgnoreCase(user.getActive())) {
                errorString = "Your account is no active yet!";
                errors.add(errorString);
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("errors", errors);
                return null;
            }
        }

        return user;
    }

    private boolean validateUserRegistrationInput(HttpServletRequest request) {
        boolean status = true;
        String name = request.getParameter("name");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("cpassword");
        String licenseNumber = request.getParameter("license");
        String telephone = request.getParameter("telephone");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");

        Set<String> errors = new HashSet<String>();
        String errorString = "";
        if (name == null || "".equalsIgnoreCase(name)) {
            errorString = "Name is required";
            errors.add(errorString);
            status = false;
        }
        if (userName == null || "".equalsIgnoreCase(userName)) {
            errorString = "User Name is required";
            errors.add(errorString);
            status = false;
        }
        if (password == null || "".equalsIgnoreCase(password)) {
            errorString = "Password is required";
            errors.add(errorString);
            status = false;
        } else {
            if (!password.equals(confirmPassword)) {
                errorString = "Password does not match";
                errors.add(errorString);
                status = false;
            }
        }
        if (licenseNumber == null || "".equalsIgnoreCase(licenseNumber)) {
            errorString = "License Number is required";
            errors.add(errorString);
            status = false;
        }
        if (gender == null || "".equalsIgnoreCase(gender)) {
            errorString = "Gender is required";
            errors.add(errorString);
            status = false;
        }

        if (telephone == null || "".equalsIgnoreCase(telephone)) {
            errorString = "Telephone is required";
            errors.add(errorString);
            status = false;
        }

        if (email == null || "".equalsIgnoreCase(email)) {
            errorString = "Email is required";
            errors.add(errorString);
            status = false;
        }

        List<User> users = dbUtil.getAllUsers();

        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                errorString = "Username already exist";
                errors.add(errorString);
                status = false;
            }
            if (user.getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
                errorString = "License Number already exist";
                errors.add(errorString);
                status = false;
            }
        }

        if (!status) {
            request.setAttribute("name", name);
            request.setAttribute("username", userName);
            request.setAttribute("license", licenseNumber);
            request.setAttribute("dob", request.getParameter("dob"));
            request.setAttribute("gender", "checked");
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("errors", errors);
        }
        return status;
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
