package handlers;

import results.HelpResult;

public class HelpHandler implements ICommandHandler {
    @Override
    public String handle(String[] name) {
        return new HelpResult().getValue(name);
    }
}
