package com.sgijsber.webblog.command;


import com.google.gson.Gson;
import com.sgijsber.webblog.command.Command;
import com.sgijsber.webblog.model.Comment;
import com.sgijsber.webblog.model.Posting;
import com.sgijsber.webblog.service.WebLogService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class AddComment_json extends Command {

    public AddComment_json(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        try {
            System.out.println("AddComment_json called");
            Long postID = Long.valueOf(request.getParameter("postID").toString());
            System.out.println(String.format("Post ID : %s", postID));
            Posting p = WebLogService.getPostingBy(postID);
            
            //Get a new comment ID
            List<Comment> comments = p.getComments();
            Long highestID = -1L;
            for (Comment comment : comments) {
                if (comment.getId() > highestID) {
                    highestID = comment.getId();
                }
            }
            
            Long newCommentID = highestID + 1L;
            
            String commentMessage = request.getParameter("Comment");
            System.out.println(String.format("Comment %s", commentMessage));
            Comment newComment = new Comment(newCommentID, commentMessage);
            
            WebLogService.addComment(postID, newComment);
            
            List commentList = WebLogService.getPostingBy(postID).getComments();
            System.out.println(String.format("JSON : %s" , new Gson().toJson(commentList)));
            response.setContentType("application/json");
            response.getWriter().write(new Gson().toJson(commentList));
        } catch (IOException ex) {
            System.err.println(String.format("IO Example, trying to convert JSON : ", ex.getMessage()));
        }
    }
    
}
