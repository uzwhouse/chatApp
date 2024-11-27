package pages;

import chat.ChatMessage;

import static chat.ChatFileOperation.readAllChatsFromFile;
import static chat.ChatFileOperation.saveChatToFile;
import static utils.Utils.readConsole;
import static utils.Utils.sessionUser;

public class ChatPage {
    public static void startChat() {
        showChatPage();
        switch (readConsole("Choice: ")) {
            case "1" -> sendMessage();
            case "2" -> chatHistory();
            case "e" -> logout();
            default -> System.out.println("Wrong choice !!!");
        }
    }

    public static void logout() {
        System.out.printf("'%s' successfully logged out\n\n", sessionUser.getEmail());
        sessionUser = null;
    }

    public static void chatHistory() {
        readAllChatsFromFile().forEach(System.out::println);
    }

    public static void sendMessage() {
        String message = readConsole("Enter your message : ");
        saveChatToFile(new ChatMessage(sessionUser.getEmail(), message));
    }

    public static void showChatPage() {
        System.out.println("1 -> Send Message");
        System.out.println("2 -> View chat history");
        System.out.println("e -> Log out");
    }
}
