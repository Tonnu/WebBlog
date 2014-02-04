/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public abstract class Command {
    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    public Command(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
    
    public abstract void execute();
    
    public void setRequest(HttpServletRequest request){
        this.request = request;
    }
    
    public void setResponse(HttpServletResponse response){
        this.response = response;
    }
    
    protected void showPage(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        request.getRequestDispatcher(url).forward(request, response);
    }  
}
