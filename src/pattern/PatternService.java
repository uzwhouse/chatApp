package pattern;

import java.util.regex.Pattern;

public class PatternService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(\\w+)@(\\p{Alpha}+)(\\.[a-zA-Z]{2,4})$");
    //  (a-z)(A-Z)(0-9) -> (\p{Lower})(\p{Upper})(\p{Digit}), [0-9] -> \d, [a-zA-Z0-9] -> \w
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*\\p{Lower}+)(?=.*\\p{Upper}+)(?=.*\\d+)(?=.*\\p{ASCII}+).{8,}$");

    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
