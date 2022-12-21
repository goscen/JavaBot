package handlers;

import results.DeleteCommandResult;

public class DeleteCommandHandler implements ICommandHandler{
    @Override
    public String handle(String[] name) {
        return new DeleteCommandResult().getValue(name);
    }
}
