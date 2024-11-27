import chat.ChatMessage;
import user.User;

import java.util.Objects;

import static chat.ChatFileOperation.writeChatToFile;
import static pages.ChatPage.startChat;
import static pages.LoginPage.loginPage;
import static user.UserFileOperation.appendUserToFile;
import static user.UserFileOperation.writeUserToFile;
import static utils.Utils.sessionUser;

public class ChatApp {

    static {
        String path = Objects.requireNonNull(ChatApp.class.getClassLoader().getResource("logging.properties")).getFile();
        System.setProperty("java.util.logging.config.file", path);
        writeUserToFile(new User("aa", "a"));
        appendUserToFile(new User("tt", "t"));
        appendUserToFile(new User("ss", "s"));
        writeChatToFile(new ChatMessage("OWNER", "Welcome to the chat!"));
    }

    public static void main(String[] args) {
        app();
    }

    private static void app() {
        if (sessionUser == null) loginPage();
        else startChat();
        app();
    }

}
