import user.User;

import static pattern.PatternService.isValidEmail;
import static pattern.PatternService.isValidPassword;
import static user.UserFileOperation.appendUserToFile;
import static user.UserFileOperation.writeUserToFile;
import static utils.Utils.readConsole;
import static utils.Utils.userService;

public class ChatApp {

    public static void main(String[] args) {
        app();
    }

    private static void app() {
        showLoginPage();
        switch (readConsole("Choice: ")) {
            case "1" -> login();
            case "2" -> register();
            case "q" -> quit();
            default -> System.out.println("Wrong choice !!!");
        }
        app();
    }

    private static void quit() {
        System.out.println("-------------------- QUIT --------------------");
        System.exit(0);
    }

    private static void register() {
        String email = readConsole("Enter your email: ");
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format !!!");
            return;
        }
        String password = readConsole("Enter your password: ");
        if (!isValidPassword(password)) {
            System.out.println("Invalid password format !!!");
            return;
        }
        userService.register(email, password);
    }

    private static void login() {
        String email = readConsole("Enter your email: ");
        String password = readConsole("Enter your password: ");
        userService.login(email, password);
    }

    public static void showLoginPage() {
        System.out.println("1 -> LOGIN");
        System.out.println("2 -> REGISTER");
        System.out.println("q -> QUIT");
    }

    static {
        writeUserToFile(new User("aa", "a"));
        appendUserToFile(new User("tt", "t"));
        appendUserToFile(new User("ss", "s"));
    }

}
