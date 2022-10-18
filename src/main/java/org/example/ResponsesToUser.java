package org.example;

import java.util.Objects;

public class ResponsesToUser {
    HelpCommand helpCommand = new HelpCommand();
    HelpHandler helpHandler = new HelpHandler();

    public String RespondToUser(String message){
        if(Objects.equals(helpCommand.getName(), message)){
            return helpHandler.handle(helpCommand).getValue();
        }

        return "Не понял";

    }
    public final String startMessage = "Для помощи напишите /help";
    public final String greetingsMessage = "Привет";
    public final String helpMessage = "Этот бот может помочь найти статистику игрока в R6S";

    public final String unknownMessage = "?";
}
