package results;

import parsers.R6Parser;
import results.ICommandResult;

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
        String kd = parser.getStat("PVPKDRatio");
        String hours = parser.getStat("PVPTimePlayed");
        String win = parser.getStat("PVPWLRatio");
        String matchPlayed = parser.getStat("PVPMatchesPlayed");
        return name + ": \n" + "KD: " + kd + "\n" + "WIN: " + win + "\n"
                + "Played Match: " + matchPlayed + "\n" + "Hours Played: " + hours;
    }
}
