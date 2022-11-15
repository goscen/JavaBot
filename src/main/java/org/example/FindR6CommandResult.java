package org.example;

public class FindR6CommandResult implements ICommandResult{
    @Override
    public String getValue() {
        return null;
    }
    @Override
    public String getValue(String name) {
        R6Parser parser = new R6Parser(name);
        parser.getDocument();
        String kd = parser.getKD();

        return "KD:" + kd + "\n";

    }
}
