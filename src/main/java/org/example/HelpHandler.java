package org.example;

public class HelpHandler implements ICommandHandler<HelpCommand, HelpResult> {
    @Override
    public HelpResult handle(HelpCommand command) {
        return new HelpResult();
    }
}
