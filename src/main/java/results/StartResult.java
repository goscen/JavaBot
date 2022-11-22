package results;

import commands.StartCommand;

public class StartResult implements ICommandResult {
    public String getValue(){return new StartCommand().getDescription();}

    @Override
    public String getValue(String name) {
        return null;
    }
}
