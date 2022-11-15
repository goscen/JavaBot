package org.example;

public class BotLogic {

    ICommand[] commands;

    BotLogic(ICommand[] commands) {
        this.commands = commands;
    }

    public String respondToUser(String message) {
        String[] splitCommand = message.split(" ");

        for (var cmd : commands) {
            if (cmd.isTriggered(splitCommand[0].toLowerCase())) {
                if (splitCommand.length == 2) {
                    System.out.println(splitCommand[1]);
                    return cmd.getHandler().handle(splitCommand[1]);
                } else if (splitCommand.length == 1) {
                    return cmd.getDescription();
                }
            }
        }
        return "?";
    }
}
