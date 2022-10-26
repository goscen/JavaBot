package org.example;

public interface ICommand {
    public String getName();
    public String getDescription();
    public boolean isTriggered(String string);
    public ICommandHandler getHandler();
}

