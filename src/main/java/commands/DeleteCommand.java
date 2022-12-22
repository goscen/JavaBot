package commands;

import handlers.DeleteCommandHandler;
import handlers.ICommandHandler;

import java.util.Objects;

public class DeleteCommand implements ICommand {
    @Override
    public String getName() {
        return "/delete";
    }

    @Override
    public boolean isTriggered(String string) {
        return Objects.equals(getName(), string);
    }

    @Override
    public ICommandHandler getHandler() {
        return new DeleteCommandHandler();
    }

    @Override
    public String getDescription() {
        return "Позволяет проверить собственную статистику";
    }
}
