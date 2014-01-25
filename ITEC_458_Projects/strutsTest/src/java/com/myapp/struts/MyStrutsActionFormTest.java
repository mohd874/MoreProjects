/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Saeed
 */
public class MyStrutsActionFormTest extends org.apache.struts.action.ActionForm {
    
   private String name;

   private String password;
   
   private String type;

   /**
    * @return
    */
   public String getName() {
       return name;
   }

   /**
    * @param string
    */
   public void setName(String string) {
       name = string;
   }

   /**
    *
    */
   public MyStrutsActionFormTest() {
       super();
       // TODO Auto-generated constructor stub
   }

   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
       ActionErrors errors = new ActionErrors();
       if (getName() == null || getName().length() < 1) {
           errors.add("name", new ActionMessage("error.name.required"));
           // TODO: add 'error.name.required' key to your resources
       }
       
       if (getPassword() == null || getPassword().length() < 1) {
           errors.add("name", new ActionMessage("error.pass.required"));
           // TODO: add 'error.name.required' key to your resources
       }
       System.out.println("TYPE: "+getType());
       return errors;
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
