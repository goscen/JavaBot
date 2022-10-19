package org.example;

import java.util.Objects;

public class HelpCommand implements ICommand<String> {

    @Override
    public String getName() {
        return "/help";
    }

    public boolean isTriggered(String str) {
        return Objects.equals(getName(), str);
    }
}
