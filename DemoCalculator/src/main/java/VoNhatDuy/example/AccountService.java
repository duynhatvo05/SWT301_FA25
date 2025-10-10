package VoNhatDuy.example;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class AccountService {

    // Mô phỏng kho dữ liệu để kiểm tra "tài khoản chưa tồn tại"
    private final Set<String> usernames = new HashSet<>();
    private final Set<String> emails = new HashSet<>();

    // ====== YÊU CẦU: 2 PHƯƠNG THỨC PUBLIC ======

    // 1) Kiểm tra email hợp lệ
    public boolean isValidEmail(String email) {
        if (isBlank(email)) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // 2) Đăng ký tài khoản theo rule của đề
    public boolean registerAccount(String username, String password, String email) {
        // bắt buộc đủ 3 trường
        if (isBlank(username) || isBlank(password) || isBlank(email)) return false;

        // username > 3 ký tự
        if (username.length() <= 3) return false;

        // email hợp lệ
        if (!isValidEmail(email)) return false;

        // tài khoản chưa tồn tại (check cả username và email)
        if (usernames.contains(username) || emails.contains(email)) return false;

        // password > 6, có ≥1 chữ hoa, ≥1 chữ số, ≥1 ký tự đặc biệt
        if (!isStrongPassword(password)) return false;

        // Lưu vào "kho" in-memory
        usernames.add(username);
        emails.add(email);
        return true;
    }

    // ====== PRIVATE: helper theo đúng rule, không yêu cầu public ======

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
