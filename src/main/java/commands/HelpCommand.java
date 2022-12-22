package commands;

import handlers.HelpHandler;

import java.util.Objects;

public class HelpCommand implements ICommand {

    @Override
    public String getName() {
        return "/help";
    }

    @Override
    public boolean isTriggered(String string) {
        return Objects.equals(getName(), string);
    }

    @Override
    public HelpHandler getHandler() {

        return new HelpHandler();
    }

    public String getDescription() {
        return  "Этот бот может помочь найти статистику игрока в:\n" +
                "/findr6 - в Rainbow 6: Siege\n" +
                "/findapex - в Apex Legends\n" +
                "/link - привязать свой аккаунт";
    }
}
