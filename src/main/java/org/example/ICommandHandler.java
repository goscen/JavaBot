package org.example;

public interface ICommandHandler<TICommand, TICommandResult> {
    public TICommandResult handle(TICommand command);
}
