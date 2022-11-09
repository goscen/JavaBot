package org.example;

public class GreetingHandler implements ICommandHandler {
    public String handle() {
        return new GreetingResult().getValue();
    }
}
