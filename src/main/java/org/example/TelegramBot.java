package org.example;

import buttons.Buttons;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        var inlineButtons = new Buttons();
        Buttons buttons = new Buttons();
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            message.setReplyMarkup(buttons.MakeButtons());
            String finalMessage = botLogic.respondToUser(update.getMessage().getText(),
                    update.getMessage().getChatId().toString());
            if(Objects.equals("/help", update.getMessage().getText())){

                message.setReplyMarkup(inlineButtons.MakeInInlineButtons());
            }
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(finalMessage);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        else if (update.hasCallbackQuery()){
            String callbackData = update.getCallbackQuery().getData();
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            if(callbackData.equals("FINDR6")){
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText("Для поиска статистики введите: /findr6 никнейм_игрока +\n" +
                        "Для того что бы привязать аккаунт введите /link никнейм_игрока \n" +
                        "После привязки можно воспользоваться /link без аргумента");
                message.setMessageId((int) messageId);
                try {
                    execute(message);
                }
                catch(TelegramApiException e){
                    e.printStackTrace();
                }
            }
            else if (callbackData.equals("FINDAPEX")){
                EditMessageText message = new EditMessageText();
                message.setChatId(String.valueOf(chatId));
                message.setText("Для поиска статистики введите: /findapex никнейм_игрока ");
                message.setMessageId((int) messageId);

                try {
                    execute(message);
                }
                catch(TelegramApiException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
