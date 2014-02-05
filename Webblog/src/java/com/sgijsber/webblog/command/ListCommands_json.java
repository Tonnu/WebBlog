/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.command;

import com.google.gson.Gson;
import com.sgijsber.webblog.service.WebLogService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class ListCommands_json extends Command {

    public ListCommands_json(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void execute() {
        try {
            List postingList = WebLogService.getPostings();
            System.out.println(String.format("JSON : %s", new Gson().toJson(postingList)));
            response.setContentType("application/json");
            response.getWriter().write(new Gson().toJson(postingList));
        } catch (IOException ex) {
            System.err.println(String.format("Error in ListCommands.execute() error writing JSON to client: %s", ex.getMessage()));
        }
    }
}
