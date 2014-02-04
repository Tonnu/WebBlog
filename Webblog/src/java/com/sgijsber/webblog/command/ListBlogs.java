/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.command;

import com.sgijsber.webblog.model.Posting;
import com.sgijsber.webblog.service.WebLogService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class ListBlogs extends Command {
    
    public ListBlogs(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        try {
            ServletContext sc = request.getServletContext();
            sc.setAttribute("postings", (ArrayList<Posting>) WebLogService.getPostings());
            
            showPage(request, response, "/WebBlog.jsp");
        } catch (ServletException | IOException ex) {
            System.err.println(String.format("Error in command ListBlogs: %s", ex.getMessage()));
        }
    }
}
