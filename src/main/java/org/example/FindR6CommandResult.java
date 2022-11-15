package org.example;

public class FindR6CommandResult implements ICommandResult {
    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getValue(String name) {
        R6Parser parser = new R6Parser(name);
        parser.getDocument();
        if (parser.bFlag == Boolean.TRUE) {
            return "Not found";
        }
        String kd = parser.getKD();
        String hours = parser.getHours();
        String win = parser.winPercent();
        String matchPlayed = parser.playedMatch();
        return name + ": \n" + "KD: " + kd + "\n" + "WIN: " + win + "\n"
                + "Played Match: " + matchPlayed + "\n" + "Hours Played: " + hours;
    }
}
