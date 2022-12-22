package handlers;

import results.FindR6CommandResult;

public class FindR6CommandHandler implements ICommandHandler {
    public String handle(String[] name) {
        return new FindR6CommandResult().getValue(name);
    }
}
