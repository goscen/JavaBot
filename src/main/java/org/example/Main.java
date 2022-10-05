package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


// todo: сделать рядом консольного бота

public class Main {
    public static void main(String[] args) {
        String botName = System.getenv("TELEGRAM_BOT_NAME");
        String botToken = System.getenv("TELEGRAM_BOT_TOKEN");


        BotLogic botLogic = new BotLogic(new responsesToUser(), new UserRequests());
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            botsApi.registerBot(new TelegramBot(botName, botToken, botLogic));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
