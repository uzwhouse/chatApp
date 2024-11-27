package pages;

import static pattern.PatternService.isValidEmail;
import static pattern.PatternService.isValidPassword;
import static utils.Utils.readConsole;
import static utils.Utils.userService;

public class LoginPage {
    public static void loginPage() {
        showLoginPage();
        switch (readConsole("Choice: ")) {
            case "1" -> login();
            case "2" -> register();
            case "5" -> getAll();
            case "q" -> quit();
            default -> System.out.println("Wrong choice !!!");
        }
    }

    public static void getAll() {
        userService.getAllUsersFromFile().forEach(System.out::println);
    }

    public static void quit() {
        System.out.println("-------------------- QUIT --------------------");
        System.exit(0);
    }

    public static void register() {
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

    public static void login() {
        String email = readConsole("Enter your email: ");
        String password = readConsole("Enter your password: ");
        userService.login(email, password);
    }

    public static void showLoginPage() {
        System.out.println("1 -> Login");
        System.out.println("2 -> Register");
        System.out.println("q -> quit");
    }
}
