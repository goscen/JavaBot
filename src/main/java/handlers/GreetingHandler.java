package handlers;

import results.GreetingResult;

public class GreetingHandler implements ICommandHandler {
    public String handle() {
        return new GreetingResult().getValue();
    }

    @Override
    public String handle(String name) {
        return null;
    }
}
