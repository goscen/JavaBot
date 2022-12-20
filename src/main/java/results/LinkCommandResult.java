package results;

import org.example.Database;
import org.telegram.telegrambots.meta.api.objects.Update;

public class LinkCommandResult implements ICommandResult {
    Database database = new Database();

    @Override
    public String getValue(String[] name) {
        database.connectDatabase();
        database.addUser(name);
        return "Успех";
    }
}
