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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class EditPost extends Command{

    public EditPost(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        try {
            Long postID = Long.valueOf(request.getParameter("postID").toString());
            String postContent = request.getParameter("Content");
            
            WebLogService.editPostContent(postID, postContent);
            
            ServletContext sc = request.getServletContext();
            sc.setAttribute("postings", (ArrayList<Posting>) WebLogService.getPostings());
            
            response.sendRedirect("/Webblog/ShowAdmin");
        } catch (IOException ex) {
            System.err.println(String.format("Error while executing ShowAdmin: %s", ex.getMessage()));
        }
    }
}
