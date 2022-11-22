package results;

import results.ICommandResult;

public class GreetingResult implements ICommandResult {
    public String getValue(){return "Привет";}

    @Override
    public String getValue(String name) {
        return null;
    }
}
