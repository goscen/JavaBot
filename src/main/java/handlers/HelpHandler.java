package handlers;

import results.HelpResult;

public class HelpHandler implements ICommandHandler {
    @Override
    public String handle() {
        return new HelpResult().getValue();
    }

    @Override
    public String handle(String name) {
        return null;
    }
}
