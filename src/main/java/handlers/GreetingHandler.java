package handlers;

import results.GreetingResult;

public class GreetingHandler implements ICommandHandler {

    @Override
    public String handle(String[] name) {
        return new GreetingResult().getValue();
    }
}
