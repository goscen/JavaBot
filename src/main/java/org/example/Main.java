package org.example;

import buttons.Buttons;
import handlers.*;
import commands.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import parsers.*;
import results.*;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        q;
        String botName = System.getenv("TELEGRAM_BOT_NAME");
        String botToken = System.getenv("TELEGRAM_BOT_TOKEN");
        ICommand[] commands = {new StartCommand(), new HelpCommand(), new GreetingCommand(), new FindR6Command()
                , new FindApexCommand()};
        Database database = new Database();
        database.connectDatabase();
        BotLogic botLogic = new BotLogic(commands);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            botsApi.registerBot(new TelegramBot(botName, botToken, botLogic));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}