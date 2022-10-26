package org.example;

import java.util.Objects;

public class HelpCommand implements ICommand{

    @Override
    public String getName() {
        return "/help";
    }

    @Override
    public boolean isTriggered(String string) {
        return Objects.equals(getName(), string);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public HelpHandler getHandler() {

        return new HelpHandler();
    }
}
