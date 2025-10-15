package VoNhatDuy.example;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class AccountService {


    private final Set<String> usernames = new HashSet<>();
    private final Set<String> emails = new HashSet<>();
    private final Set<String> existingUsernames = new HashSet<>();
    private final Set<String> existingEmails    = new HashSet<>();


    public boolean isValidEmail(String email) {
        if (isBlank(email)) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean registerAccount(String username, String password, String email) {
        if (isBlank(username) || isBlank(password) || isBlank(email)) return false;

        if (username.length() <= 3) return false;

        if (existingUsernames.contains(username)) return false;

        if (!isValidEmail(email)) return false;

        if (existingEmails.contains(email)) return false;

        if (usernames.contains(username) || emails.contains(email)) return false;

        if (!isStrongPassword(password)) return false;

        usernames.add(username);
        emails.add(email);
        existingUsernames.add(username);
        existingEmails.add(email);
        return true;
    }


    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    private static final Pattern UPPER = Pattern.compile(".*[A-Z].*");
    private static final Pattern DIGIT = Pattern.compile(".*\\d.*");
    private static final Pattern SPECIAL = Pattern.compile(".*[^A-Za-z0-9].*");

    private boolean isStrongPassword(String password) {
        if (isBlank(password)) return false;
        if (password.length() <= 6) return false;
        if (!UPPER.matcher(password).matches()) return false;
        if (!DIGIT.matcher(password).matches()) return false;
        if (!SPECIAL.matcher(password).matches()) return false;
        return true;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
