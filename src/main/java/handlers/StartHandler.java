package handlers;

import results.StartResult;

public class StartHandler implements ICommandHandler {
    @Override
    public String handle(String[] name) {
        return new StartResult().getValue();
    }
}
