package org.example;

import java.util.Objects;

public class GreetingCommand implements ICommand{
    public String getName(){return "привет";}

    public boolean isTriggered(String string){
        return Objects.equals(getName(), string);
    }

    public GreetingHandler getHandler(){
        return new GreetingHandler();
    }

    public String getDescription(){
        return null;
    }

}
