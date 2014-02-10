/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.command;

import com.sgijsber.webblog.service.WebLogService;
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
public class ChangeMode extends Command {

    public ChangeMode(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        try {
            WebLogService.changeAdvancedMode();
            response.sendRedirect("/Webblog/ShowAdmin");
        } catch (IOException ex) {
            System.err.println(String.format("Error in ChangeMode.execute() : %s", ex.getMessage()));
        } 
    }
}
