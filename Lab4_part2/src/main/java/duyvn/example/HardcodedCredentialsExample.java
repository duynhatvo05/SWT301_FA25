package duyvn.example;

import java.util.logging.Logger;

public class HardcodedCredentialsExample {

    private static final Logger LOG =
            Logger.getLogger(HardcodedCredentialsExample.class.getName());

    public static void main(String[] args) {
        String username = "admin";
        String password = "123456"; // hardcoded password (giữ nguyên theo bài lab)
        if (authenticate(username, password)) {
            LOG.info("Access granted");
        } else {
            LOG.warning("Access denied");
        }
    }

    private static boolean authenticate(String user, String pass) {
        // Dummy authentication logic (giữ nguyên theo bài lab)
        return user.equals("admin") && pass.equals("123456");
    }
}
