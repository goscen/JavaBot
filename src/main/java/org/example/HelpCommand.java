package org.example;

import java.util.Objects;

public class HelpCommand implements ICommand<String> {

    @Override
    public String getName() {
        return "/help";
    }

    @Override
    public boolean isTriggered(String string) {
        return Objects.equals(getName(), string);
    }

    @Override
    public HelpHandler getHandler() {

        return new HelpHandler();
    }
}
