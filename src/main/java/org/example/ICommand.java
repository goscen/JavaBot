package org.example;

public interface ICommand {
    public String getName();
    public boolean isTriggered(String string);
    public ICommandHandler getHandler();
    public String getDescription();
}

