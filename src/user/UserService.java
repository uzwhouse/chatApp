package user;

import java.util.LinkedHashSet;

import static user.UserFileOperation.loggerForUser;
import static user.UserFileOperation.readAllUsersFromFile;
import static utils.Utils.readConsole;

public class UserService {
    public void register(String email, String password) {
        try {
            UserFileOperation.writeUserToFile(new User(email, password));
            loggerForUser.config("User registered successfully: " + email);
        } catch (Exception e) {
            loggerForUser.config("Registration failed: " + e.getMessage());
            System.out.println("Registration failed. Try again.");
        }
    }

    public void login(String email, String password) {
        User user = findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            loggerForUser.config("User logged in successfully: " + email);
            System.out.println("Login successful! Welcome " + user.getEmail());
            chat(user);
        }
        System.out.println("Invalid email or password.");
        loggerForUser.config("Invalid email or password. Try again.");
    }

    private void chat(User user) {
        while (true) {
            String message = readConsole("Enter your message (or type 'exit' to log out):");
            if (message.equals("exit")) {
                loggerForUser.config("User logged out: " + user.getEmail());
                break;
            }
        }
    }

    private User findByEmail(String email) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        for (User user : localUsers)
            if (user.getEmail().equalsIgnoreCase(email))
                return user;
        return null;
    }
}
