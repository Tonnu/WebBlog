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
public class AdvancedMode extends Command{

    public AdvancedMode(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        try {
            showPage(request, response, "WEB-INF/WebBlogAdm_advanced.jsp");
        } catch (ServletException | IOException ex) {
            System.err.println(String.format("Exception in AdvancedMode.execute() : %s", ex.getMessage()));
        }
    }
    
}
