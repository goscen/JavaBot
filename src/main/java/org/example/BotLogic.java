package org.example;

import java.util.Objects;

public class BotLogic {
    private final responsesToUser response;
    private final UserRequests request;

    public String respondToUser(Long userId, String message) {
        message = message.toLowerCase();
        if (Objects.equals(message, request.startMessage)) {
            return response.startMessage;
        } else if (Objects.equals(message, request.helpMessage)) {
            return response.helpMessage;
        } else if (Objects.equals(message, request.greetingsMessage)) {
            return response.greetingsMessage;

        }
        return response.unknownMessage;
    }
    public BotLogic(responsesToUser response, UserRequests request){
        this.response = response;
        this.request = request;
    }

}
