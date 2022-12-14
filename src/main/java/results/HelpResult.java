package results;

import commands.HelpCommand;
import results.ICommandResult;

public class HelpResult implements ICommandResult {

    @Override
    public String getValue(String[] name) {
        return (new HelpCommand().getDescription());
    }
}
