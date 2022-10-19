package org.example;

import java.util.Objects;

public class ResponsesToUser {
    HelpCommand helpCommand = new HelpCommand();
    HelpHandler helpHandler = new HelpHandler();

    ICommand [] commands;
    ICommandHandler[] commandHandlers;

    public ResponsesToUser(ICommand[] commands, ICommandHandler[] handlers) {
        this.commands = commands;
        this.commandHandlers = handlers;
    }

    public String RespondToUser(String message){
        for(var cmd: commands) {
            if (cmd.isTriggered(message)) {
                cmd.handle(message);
            }
        }

    }
    public String RespondToUser(String message){
        if(helpCommand.isTriggered(message)){
            return helpHandler.handle(helpCommand);
        }

        return "Не понял";

    }
    public final String startMessage = "Для помощи напишите /help";
    public final String greetingsMessage = "Привет";
    public final String helpMessage = "Этот бот может помочь найти статистику игрока в R6S";

    public final String unknownMessage = "?";
}
