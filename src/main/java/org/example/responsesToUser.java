package org.example;

// todo: классы с большой буквы
public class responsesToUser {

    public final String startMessage = "Для помощи напишите /help";
    public final String greetingsMessage = "Привет";
    public final String helpMessage = "Этот бот может помочь найти статистику игрока в R6S";

    public final String unknownMessage = "?";
}


public interface ICommand {
    public String getName(); // \help

}

public interface ICommandResult {

}
class HelpCommand {

}
class HelpResult implements ICommandResult {
    public String Value;
}

public interface ICommandHandler<TICommand, TICommandResult> {
    public TICommandResult handle(TICommand command);
}


class HelpHandler implements ICommandHandler<HelpCommand, HelpResult> {
    @Override
    public HelpResult handle(HelpCommand command) {
        return new HelpResult().;
    }
}