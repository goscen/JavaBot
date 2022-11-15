package org.example;

public class StartHandler implements ICommandHandler {
    public String handle(){return new StartResult().getValue();}

    @Override
    public String handle(String name) {
        return null;
    }
}
