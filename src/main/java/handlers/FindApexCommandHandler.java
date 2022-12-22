package handlers;

import results.FindApexCommandResult;
import results.FindR6CommandResult;

public class FindApexCommandHandler implements ICommandHandler {


    @Override
    public String handle(String[] name) {
        return new FindApexCommandResult().getValue(name);
    }
}
