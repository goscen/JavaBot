package results;

import parsers.ApexParser;

public class FindApexCommandResult implements ICommandResult {

    @Override
    public String getValue(String[] name) {
        ApexParser parser = new ApexParser(name[0]);
        parser.getDocument();
        if (parser.bFlag == Boolean.TRUE) {
            return "Not found";
        }
        return null;

    }
}
