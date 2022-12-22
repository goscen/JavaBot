package commands;

import handlers.FindApexCommandHandler;
import handlers.FindR6CommandHandler;
import handlers.ICommandHandler;

import java.util.Objects;

public class FindApexCommand implements ICommand {
    @Override
    public String getName() {
        return "/findapex";
    }

    @Override
    public boolean isTriggered(String string) {
        return  Objects.equals(getName(), string);
    }

    @Override
    public ICommandHandler getHandler() {
        return new FindApexCommandHandler();
    }

    @Override
    public String getDescription() {
        return "Для поиска статистики введите: /findapex никнейм_игрока ";
    }
}
