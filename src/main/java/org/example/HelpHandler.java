package org.example;

public class HelpHandler implements ICommandHandler<HelpCommand, String> {
    @Override
    public String handle(HelpCommand command) {
        return new HelpResult().getValue();
    }
}
