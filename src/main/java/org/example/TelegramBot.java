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
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            String finalMessage = botLogic.respondToUser(update.getMessage().getChatId(),update.getMessage().getText()) ;
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(finalMessage);


            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
