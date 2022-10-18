package org.example;

public class HelpCommand implements ICommand {

    @Override
    public String getName() {
        return "/help";
    }
}
