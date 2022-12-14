package commands;

import handlers.FindR6CommandHandler;
import handlers.ICommandHandler;

import java.util.Objects;

public class FindR6Command implements ICommand {
    @Override
    public String getName() {
        return "/findr6";
    }

    @Override
    public String getDescription() {
        return "Для поиска статистики введите: /findr6 никнейм_игрока \n" +
                "Для того что бы привязать аккаунт введите /link никнейм_игрока \n" +
                "После привязки можно воспользоваться /link без аргумента";
    }

    @Override
    public boolean isTriggered(String string) {
        return Objects.equals(getName(), string);
    }

    @Override
    public ICommandHandler getHandler() {
        return new FindR6CommandHandler();
    }
}
