/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.command;

import com.sgijsber.webblog.model.Comment;
import com.sgijsber.webblog.model.Posting;
import com.sgijsber.webblog.service.WebLogService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class AddComment extends Command {

    public AddComment(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        try{
            Long postID = Long.valueOf(request.getParameter("hidden_postID").toString());
            Posting p = WebLogService.getPostingBy(postID);
            
            //Get a new comment ID
            List<Comment> comments = p.getComments();
            Long highestID = 0L;
            for (Comment comment : comments){
                if (comment.getId() > highestID){
                    highestID = comment.getId();
                }
            }
            
            Long newCommentID = highestID + 1L;
            
            String commentMessage = request.getParameter("Comment");
            Comment newComment = new Comment(newCommentID, commentMessage);
            
            WebLogService.addComment(postID, newComment);
            
            showPage(request, response, "ListBlogs");
            
        } catch (NumberFormatException nfe) {
            System.err.println("Error in AddComment execute(), unable to convert String postID to Long postID");
            System.err.println(String.format("Corresponding NumberFormatException: %s", nfe.getMessage()));
        } catch (ServletException | IOException ex) {
            System.err.println(String.format("Error in AddComment execute(): %s", ex.getMessage()));
        }
    }
}
