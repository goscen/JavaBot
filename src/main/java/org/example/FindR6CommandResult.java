package org.example;

public class FindR6CommandResult implements ICommandResult{
    @Override
    public String getValue() {
        return null;
    }
    public String getValue(String name) {
        R6Parser parser = new R6Parser(name);
        String kd = parser.getKD();
        String hours = parser.getHours();
        String wins = parser.winPercent();
        String playedMatch = parser.playedMatch();
        return "KD:" + kd + "\n";
    }
}
