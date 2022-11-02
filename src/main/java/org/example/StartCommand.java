package org.example;

import java.util.Objects;

public class StartCommand implements ICommand{
    public String getName(){return "/start";}
    public boolean isTriggered(String string){
        return Objects.equals(getName(),string);
    }
    public StartHandler getHandler(){
        return new StartHandler();
    }
    public String getDescription(){
        return "Напишите /help для подробной информации по командам бота";
    }
}
