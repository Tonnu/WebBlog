/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.command;

import com.sgijsber.webblog.model.Posting;
import com.sgijsber.webblog.service.WebLogService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class AddPost extends Command  {

    public AddPost(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        String title = (String) request.getParameter("Title");
        String posting = (String) request.getParameter("Posting");
        
        Posting newPost = new Posting(title, posting);
        WebLogService.addPosting(newPost);
        
        try {
            showPage(request, response, "ListBlogs");
        } catch (ServletException | IOException ex) {
            System.err.println("Could not redirect from command AddPost to /WebBlog.jsp");
        }
    }
}
