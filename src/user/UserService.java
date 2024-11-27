package user;

import java.util.LinkedHashSet;

import static user.UserFileOperation.*;
import static utils.Utils.sessionUser;

public class UserService {
    public void register(String email, String password) {
        if (findByEmail(email) == null) {
            appendUserToFile(new User(email, password));
            System.out.printf("'%s' successfully registered\n\n", email);
            loggerForUser.config("User registered successfully: " + email);
        } else {
            loggerForUser.config("User already exist:");
            System.out.println("User already exist:. Try again.\n");
        }

    }

    public void login(String email, String password) {
        User user = findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            sessionUser = user;
            loggerForUser.config("User logged in successfully: " + email);
            System.out.println("Login successful! Welcome " + user.getEmail() + "\n");
        } else {
            System.out.println("Invalid email or password.\n");
            loggerForUser.config("Invalid email or password. Try again.");
        }
    }


    private User findByEmail(String email) {
        LinkedHashSet<User> localUsers = readAllUsersFromFile();
        for (User user : localUsers)
            if (user.getEmail().equalsIgnoreCase(email))
                return user;
        return null;
    }

    public LinkedHashSet<User> getAllUsersFromFile() {
        return readAllUsersFromFile();
    }

}
