import VoNhatDuy.example.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

    @ParameterizedTest(name = "row {index}: {0},{1},{2} -> expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @DisplayName("Một test cho cả registerAccount & isValidEmail (CSV)")
    void register_and_isValidEmail(String username, String password, String email, boolean expected) {
        AccountService service = new AccountService();

        // Kiểm tra isValidEmail trước (độc lập)
        boolean emailValid = service.isValidEmail(email);

        // Kiểm tra registerAccount theo expected trong CSV
        boolean registered = service.registerAccount(username, password, email);
        assertEquals(expected, registered,
                () -> "registerAccount unexpected for username=" + username + ", email=" + email);

        // Ràng buộc logic giữa 2 hàm:
        // - Nếu email KHÔNG hợp lệ -> chắc chắn register phải fail
        if (!emailValid) {
            assertFalse(registered, "Invalid email must not be registered");
        }

        // - Nếu register thành công -> email phải hợp lệ + username > 3 + không rỗng
        if (registered) {
            assertTrue(emailValid, "Email must be valid when registration succeeds");
            assertNotNull(username, "Username must not be null when registration succeeds");
            assertTrue(username.trim().length() > 3, "Username length must be > 3 when registration succeeds");
        }
    }
}
