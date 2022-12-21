package results;

import org.example.Database;

public class DeleteCommandResult implements ICommandResult {
    Database database = new Database();

    @Override
    public String getValue(String[] name) {
        database.connectDatabase();
        String data = database.deleteData(name);

        return data;
    }
}
