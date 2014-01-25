/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.controller;

import com.me.model.MathQuestion;
import com.me.model.MathQuestionsManager;
import java.io.*;
import java.net.*;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Saeed
 */
public class MathServlet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
       
        
        String action = req.getParameter("action");
        List<MathQuestion> questions = (List<MathQuestion>)req.getSession().getAttribute("questions");
        
        int index;
        String indexString = req.getParameter("index");
        
        if(questions == null){
            questions = MathQuestionsManager.getQuestions();
            System.out.println("Questions generated");
            req.getSession().setAttribute("questions", questions);
        }
        
        if(indexString == null){
            index = 0;
        }else{
            try{
                index = Integer.parseInt(indexString);
            }catch(NumberFormatException e){
                index = 0;
            }
        }
        
        String url = "/questionPage.jsp";
        if(action == null){
            req.setAttribute("currentQuestion", questions.get(0).getQuestionString());
        }else if("Submit".equalsIgnoreCase(action) && (index+1) < questions.size()){
            String answer = req.getParameter("answer");
            String result = MathQuestionsManager.evaluateAnswer(questions.get(index), answer);
            req.setAttribute("questionMessage", result);            
            index++;
            req.setAttribute("currentQuestion", questions.get(index).getQuestionString());
        }else{
            String answer = req.getParameter("answer");
            MathQuestionsManager.evaluateAnswer(questions.get(index), answer);
            req.setAttribute("score", MathQuestionsManager.getScore());
            url = "/resultPage.jsp";
        }
        
        req.setAttribute("questionNumber", (index+1));
        req.setAttribute("index", index);
        debug(req);
        req.getRequestDispatcher(url).forward(req, resp);
    } 

    public void debug(HttpServletRequest req){
        System.out.println("action: "+req.getParameter("action"));
        System.out.println("currentQuestion: "+req.getAttribute("currentQuestion"));
        System.out.println("questionMessage: "+req.getAttribute("questionMessage"));
        System.out.println("questionNumber: "+req.getAttribute("questionNumber"));
        System.out.println("questions: "+req.getSession().getAttribute("questions"));
        
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
