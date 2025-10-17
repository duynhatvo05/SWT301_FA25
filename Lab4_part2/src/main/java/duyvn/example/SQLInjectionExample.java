package duyvn.example;

import java.util.logging.Logger;

public class SQLInjectionExample {
    private static final Logger LOG =
            Logger.getLogger(SQLInjectionExample.class.getName());

    public static void main(String[] args) {
        String userInput = "' OR '1'='1";
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        // dùng Supplier để tránh cảnh báo nối chuỗi khi log (S3457)
        LOG.info(() -> "Executing query: " + query);
    }
}

