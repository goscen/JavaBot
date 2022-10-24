package org.example;

public class ResponsesToUser {
    HelpCommand helpCommand = new HelpCommand();


    ICommand[] commands;
    ICommandHandler[] commandHandlers;

    public ResponsesToUser(ICommand[] commands, ICommandHandler[] handlers) {
        this.commands = commands;
        this.commandHandlers = handlers;
    }

    public String RespondToUser(String message) {
        int counter = 0;
        for (var cmd : commands) {
            if (cmd.isTriggered(message)) {
                return commandHandlers[counter].handle();
            }
            counter ++;
        }
        return "?";
    }
}
