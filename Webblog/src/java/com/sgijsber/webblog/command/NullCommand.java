/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class NullCommand extends Command{
    
    public String URL = "NotFound";

    public NullCommand(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
    
    @Override
    public void execute() {
        try {
            showPage(request, response, "/WEB-INF/NotFoundPage.jsp");
        } catch (ServletException | IOException ex) {
            System.err.println(String.format("Exception during execution of NullCommand : %s", ex.getMessage()));
        } 
    }
}
