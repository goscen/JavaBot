package org.example;

public class FindR6CommandHandler implements ICommandHandler{
    @Override
    public String handle() {
        return new FindR6CommandResult().getValue();
    }
}
