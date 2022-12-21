package org.example;

import commands.ICommand;
import commands.LinkCommand;

import java.util.Objects;

public class BotLogic {
    ICommand[] commands;

    BotLogic(ICommand[] commands) {
        this.commands = commands;
    }

    public String respondToUser(String message, String id) {
        String[] splitCommand = message.split(" ");

        for (var cmd : commands) {
            if (cmd.isTriggered(splitCommand[0].toLowerCase())) {
                if (splitCommand.length == 2) {
                    splitCommand[0] = id;
                    return cmd.getHandler().handle(splitCommand);
                } else if (splitCommand.length == 1) {
                    if (Objects.equals(splitCommand[0], "/link") ||
                            Objects.equals(splitCommand[0], "/delete")) {
                        splitCommand[0] = id;
                        return cmd.getHandler().handle(splitCommand);
                    }
                    return cmd.getDescription();
                }
            }
        }
        return "?";
    }
}
