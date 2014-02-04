/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgijsber.webblog.command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class CommandFactory{

    private Map<String, Command> commands;
    private CommandFactory instance = null;

    public CommandFactory() {
        this.instance = this;
        
        commands = new HashMap<String, Command>();
        commands.put("NotFound", new NullCommand(null, null));
        commands.put("/ListBlogs", new ListBlogs(null, null));
        commands.put("/ShowAdmin", new ShowAdmin(null, null));
        commands.put("/AddPost", new AddPost(null, null));
        commands.put("/AddComment", new AddComment(null, null));
        
        System.out.println("--- CommandFactory Initialized");
    }

    public CommandFactory getCommandFactory() {
        return instance;
    }

    public void registerCommand(String commandName, Command command) {
        this.commands.put(commandName, command);
    }

    public Command createCommand(String url, HttpServletRequest request, HttpServletResponse reponse) {
        Command returnCommand = this.commands.get(url);

        if (returnCommand == null) {
            returnCommand = this.commands.get("NotFound");
        } else {
            returnCommand.setRequest(request);
            returnCommand.setResponse(reponse);
        }

        return returnCommand;
    }

}
