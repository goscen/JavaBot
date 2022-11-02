package org.example;

public class HelpResult implements ICommandResult {

    @Override
    public String getValue() {
        return (new HelpCommand().getDescription());
    }
}
