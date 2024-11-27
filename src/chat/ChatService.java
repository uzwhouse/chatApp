package chat;

import user.User;

import static user.UserFileOperation.loggerForUser;
import static utils.Utils.readConsole;

public class ChatService {



    private void chat(User user) {
        while (true) {
            String message = readConsole("Enter your message (or type 'exit' to log out): ");
            if (message.equals("exit")) {
                loggerForUser.config("User logged out: " + user.getEmail());
                break;
            }

        }
    }
}
