package org.example;

public class StartHandler implements ICommandHandler {
    public String handle(){return new StartResult().getValue();}
}
