package chat;

import user.User;
import user.UserFileOperation;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatFileOperation {
    public static Logger loggerForChat = Logger.getLogger(UserFileOperation.class.getName());

    public static final String CHATS_FILE_PATH = "data/chat.dat";

    public static void writeChatToFile(ChatMessage chatMessage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(CHATS_FILE_PATH))) {
            objectOutputStream.writeObject(chatMessage);
        } catch (Exception e) {
            loggerForChat.log(Level.WARNING, "writeChatToFile", e);
//            throw new RuntimeException(e.getMessage() + "writeChatToFile");
        }
    }

    public static void saveChatToFile(ChatMessage chatMessage) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(CHATS_FILE_PATH, true)){
            @Override
            protected void writeStreamHeader() throws IOException {

            }
        }) {
            objectOutputStream.writeObject(chatMessage);
        } catch (Exception e) {
            loggerForChat.log(Level.WARNING, "appendChatToFile", e);
//            throw new RuntimeException(e.getMessage() + "writeChatToFile");
        }
    }

    public static LinkedList<ChatMessage> readAllChatsFromFile() {
        LinkedList<ChatMessage> chats = new LinkedList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(CHATS_FILE_PATH))) {
            while (true) {
                try {
                    chats.add((ChatMessage) objectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            loggerForChat.log(Level.WARNING, "readAllChatsFromFile", e);
//            throw new RuntimeException(e.getMessage() + "readAllChatsFromFile");
        }
        return chats;
    }

}
