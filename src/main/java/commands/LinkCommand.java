package commands;

import handlers.ICommandHandler;
import handlers.LinkCommandHandler;

import java.util.Objects;

public class LinkCommand implements ICommand {

    @Override
    public String getName() {
        return "/link";
    }

    @Override
    public boolean isTriggered(String string) {
        return Objects.equals(getName(), string);
    }

    @Override
    public LinkCommandHandler getHandler() {
        return new LinkCommandHandler();
    }

    @Override
    public String getDescription() {
       return "Чтобы привязать свой аккаунт";
    }
}
