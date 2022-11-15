package org.example;

public class HelpResult implements ICommandResult {

    @Override
    public String getValue() {
        return (new HelpCommand().getDescription());
    }

    @Override
    public String getValue(String name) {
        return null;
    }
}
