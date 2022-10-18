package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {

    private final String botName;
    private final String botToken;

    private final BotLogic botLogic;
    TelegramBot(String botName, String botToken, BotLogic botLogic) {
        this.botName = botName;
        this.botToken = botToken;
        this.botLogic = botLogic;
    }

    @Override
    public String getBotUsername() {

        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            String finalMessage = botLogic.RespondToUser(update.getMessage().getText());
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(finalMessage);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
