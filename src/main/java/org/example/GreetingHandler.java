package org.example;

public class GreetingHandler implements ICommandHandler {
    public String handle() {
        return new GreetingResult().getValue();
    }

    @Override
    public String handle(String name) {
        return null;
    }
}
