package handlers;

import results.LinkCommandResult;

public class LinkCommandHandler implements ICommandHandler {

    @Override
    public String handle(String[] name) {
        return new LinkCommandResult().getValue(name);
    }


}
