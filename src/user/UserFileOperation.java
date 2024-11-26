package user;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserFileOperation {
    public static Logger loggerForUser = Logger.getLogger(UserFileOperation.class.getName());
    public static final String USERS_FILE_PATH = "data/users.txt";

    public static void writeUserToFile(User user) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH))) {
            objectOutputStream.writeObject(user);
        } catch (Exception e) {
            loggerForUser.log(Level.WARNING, "writeUserToFile", e);
//            throw new RuntimeException(e.getMessage() + "writeUserToFile");
        }
    }

    public static void writeUsersListToFile(LinkedHashSet<User> users) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH))) {
            for (User user : users) {
                objectOutputStream.writeObject(user);
            }
        } catch (Exception e) {
            loggerForUser.log(Level.WARNING, "writeUsersListToFile", e);
//            throw new RuntimeException(e.getMessage() + "writeUsersListToFile");
        }
    }

    public static void appendUserToFile(User user) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH, true)) {
            @Override
            protected void writeStreamHeader() throws IOException {

            }
        }) {
            objectOutputStream.writeObject(user);
        } catch (Exception e) {
            loggerForUser.log(Level.WARNING, "appendUserToFile", e);
//            throw new RuntimeException(e.getMessage() + "appendUserToFile");
        }
    }

    public static LinkedHashSet<User> readAllUsersFromFile() {
        LinkedHashSet<User> localUsers = new LinkedHashSet<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(USERS_FILE_PATH))) {
            while (true) {
                try {
                    localUsers.add((User) objectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            loggerForUser.log(Level.WARNING, "readAllUsersFromFile", e);
//            throw new RuntimeException(e.getMessage() + "readAllUsersFromFile");
        }
        return localUsers;
    }
}
