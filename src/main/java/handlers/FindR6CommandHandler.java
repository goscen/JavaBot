package handlers;

import results.FindR6CommandResult;

public class FindR6CommandHandler implements ICommandHandler {

    @Override
    public String handle() {

        return new FindR6CommandResult().getValue();
    }
    public String handle(String name) {

        return new FindR6CommandResult().getValue(name);
    }
}
