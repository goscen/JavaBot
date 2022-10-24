package org.example;

public interface ICommand<TOut> {
    public String getName();
    public boolean isTriggered(String string);
    public ICommandHandler getHandler();
}

