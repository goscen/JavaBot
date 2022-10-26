package org.example;

public class BotLogic {

    ICommand[] commands;

    BotLogic(ICommand[] commands) {
        this.commands = commands;
    }

    public String respondToUser(String message) {
        for (var cmd : commands) {
            if (cmd.isTriggered(message)) {
                return cmd.getHandler().handle();
            }
        }
        return "?";
    }
}
