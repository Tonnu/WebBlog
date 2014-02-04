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
public class ShowAdmin extends Command{

    public ShowAdmin(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        try {
            showPage(request, response, "WEB-INF/WebBlogAdm.jsp");
        } catch (ServletException | IOException ex) {
            System.err.println(String.format("Error while executing ShowAdmin: %s", ex.getMessage()));
        }
    }
}
