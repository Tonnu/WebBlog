/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sgijsber.webblog.command;

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
        //If you are executed, do nothing
    }
    
    @Override
    public void setRequest(HttpServletRequest request){
        //Ignore when this is setted
    }
    
    @Override
    public void setResponse(HttpServletResponse response){
        //Ignore when this is setted
    }
}
