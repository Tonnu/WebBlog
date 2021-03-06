/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.controller;

import com.sgijsber.webblog.command.Command;
import com.sgijsber.webblog.command.CommandFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name="BlogViewServlet", urlPatterns={"/BlogViewServlet","/ListBlogs","/ShowAdmin",
                                                 "/AddPost","/AddComment","/AddComment.json",
                                                 "/ListCommands.json","/AdvancedMode","/EditPostContent",
                                                 "/RemovePost", "/ChangeMode"})
public class BlogViewServlet extends HttpServlet {
    
    private CommandFactory commandFactory;

    @Override
    public void init() {
        System.out.println("--- BlogViewServlet initialized");
        
        commandFactory = new CommandFactory();
        System.out.println(String.format("--- Factory instance: %s ", commandFactory.toString()));
        System.out.println("---");
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Retrieve the request path
        System.out.println("Processing request");
        String userPath = request.getServletPath();
        
        //Create a Command from the CommandFactory
        System.out.println(String.format("User path: %s", userPath));
        Command command = commandFactory.createCommand(userPath, request, response);
        command.execute();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("BlogViewServlet doGet called");
        
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("BlogViewServlet doPost called");
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
