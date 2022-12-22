package results;

import org.example.Database;
import org.telegram.telegrambots.meta.api.objects.Update;

public class LinkCommandResult implements ICommandResult {
    Database database = new Database();

    @Override
    public String getValue(String[] name) {
        database.connectDatabase();
        if (name.length == 2){
            return database.addUser(name);
        }
        else{
            return database.getData(name);
        }
    }
}
