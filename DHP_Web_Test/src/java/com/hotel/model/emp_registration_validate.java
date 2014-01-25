
package com.hotel.model;

public class emp_registration_validate {
    
    
    public emp_registration_validate() {
        
    }
    
    /*String uname = request.getParameter("user_name");
        String password = request.getParameter("password");
        String con_password = request.getParameter("con_password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone_number");
        String mobile = request.getParameter("mobile_number");
        String address = request.getParameter("address");
        String passport = request.getParameter("passport_number");
        String nationality = request.getParameter("nationality");
        String job_title = request.getParameter("job_title");
        String marital_status = request.getParameter("marital_status");
        String gender = request.getParameter("gender");
        String years_of_exp = request.getParameter("years_of_exp");
        String service_no = request.getParameter("service_type");
     */
    public String validate(String uname,String password,String con_password,String name,String surname,String phone,
            String mobile,String b_o_box,String address,String passport,String nationality,String job_title,String marital_status,
            String gender,String years_of_exp, String service_no){
        
        String msg = "";
        
        //uname, name, surname, password, con_password, address, passport, nationality, job_title, marital_status,
        //gender
        
        if(uname.equalsIgnoreCase(null) || uname.equalsIgnoreCase("")){
            msg += "no user name<br>";
        }
        if(name.equalsIgnoreCase(null) || name.equalsIgnoreCase("")){
            msg += "no name<br>";
        }
        if(surname.equalsIgnoreCase(null) || surname.equalsIgnoreCase("")){
            msg += "no surname<br>";
        }
        if(password.equalsIgnoreCase(null) || password.equalsIgnoreCase("")){
            msg += "no password<br>";
        }
        if(con_password.equalsIgnoreCase(null) || con_password.equalsIgnoreCase("")){
            msg += "confirm your password<br>";
        }
        if(address.equalsIgnoreCase(null) || address.equalsIgnoreCase("")){
            msg += "no address<br>";
        }
        if(b_o_box.equalsIgnoreCase(null) || b_o_box.equalsIgnoreCase("")){
            msg += "no b_o_box<br>";
        }
        if(nationality.equalsIgnoreCase(null) || nationality.equalsIgnoreCase("")){
            msg += "choose a nationality<br>";
        }
        if(job_title.equalsIgnoreCase(null) || job_title.equalsIgnoreCase("")){
            msg += "no job title<br>";
        }
        if(marital_status.equalsIgnoreCase(null) || marital_status.equalsIgnoreCase("")){
            msg += "choose your marital status<br>";
        }
        if(gender.equalsIgnoreCase(null) || gender.equalsIgnoreCase("")){
            msg += "choose your gender<br>";
        }
        //matching the password
        if(!password.equalsIgnoreCase(con_password)){
            msg += "passwords are not matched<br>";
        }
        
        //validating numiric fields
        //years_of_exp
        if(years_of_exp.equalsIgnoreCase(null) || years_of_exp.equalsIgnoreCase("")){
            msg += "no years of experience<br>";
        }else{
            try {
                int number = Integer.parseInt(years_of_exp);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                msg += "years of experience should be a number<br>";
            }
        }
        //phone
        if(phone.equalsIgnoreCase(null) || phone.equalsIgnoreCase("")){
            msg += "no phone<br>";
        }else{
            String current_number;
            boolean numbersIsAllDigits = true;
            for(int i=0; i<phone.length(); i++){
                try {
                    current_number = phone.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "phone numbers are not fully digits<br>";
                    break;
                }
            }
        }
        //mobile
        if(mobile.equalsIgnoreCase(null) || mobile.equalsIgnoreCase("")){
            msg += "no mobile<br>";
        }else{
            String current_number;
            boolean numbersIsAllDigits = true;
            for(int i=0; i<mobile.length(); i++){
                try {
                    current_number = mobile.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "mobile numbers are not fully digits<br>";
                    break;
                }
            }
        }
        //service_no
        if(service_no.equalsIgnoreCase(null) || service_no.equalsIgnoreCase("")){
            msg += "choose the type of service<br>";
        }else{
            try {
                int number = Integer.parseInt(service_no);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                msg += "the service type is invalid<br>";
            }
        }
        
        
        return msg;
    }
    
}
