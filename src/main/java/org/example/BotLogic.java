package org.example;

public class BotLogic {
    HelpCommand HelpCommand = new HelpCommand();

    ICommand[] commands = {new HelpCommand()};
    ICommandHandler[] commandsHandlers = {new HelpHandler()};
    ResponsesToUser responsesToUser = new ResponsesToUser(commands, commandsHandlers);
    public String RespondToUser(String message) {
        return responsesToUser.RespondToUser(message);
    }

    /* private final responsesToUser response;
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
    */


}
