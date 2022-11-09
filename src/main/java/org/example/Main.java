package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        String botName = System.getenv("TELEGRAM_BOT_NAME");
        String botToken = System.getenv("TELEGRAM_BOT_TOKEN");

        ICommand commands[] = {new HelpCommand(), new StartCommand(), new GreetingCommand(), new FindR6Command()};
        BotLogic botLogic = new BotLogic(commands);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            botsApi.registerBot(new TelegramBot(botName, botToken, botLogic));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
