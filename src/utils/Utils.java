package utils;

import user.User;
import user.UserService;

import java.util.Scanner;

public class Utils {
    public static UserService userService = new UserService();
    public static User sessionUser = null;

    public static Scanner scanner = new Scanner(System.in);

    public static String readConsole(String hint) {
        System.out.print(hint);
        return scanner.nextLine();
    }

}
