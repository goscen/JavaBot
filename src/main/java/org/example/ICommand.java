package org.example;

public interface ICommand<TOut> {
    public String getName();
    public boolean isTriggered(String a);
    public ICommandHandler<? extends ICommand, TOut> getHandler();
}
