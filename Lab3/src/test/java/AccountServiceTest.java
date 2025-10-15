import VoNhatDuy.example.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountServiceTest {

    @ParameterizedTest(name = "row {index}: {0},{1},{2} -> expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @DisplayName("Một test cho cả registerAccount & isValidEmail (CSV)")
    void register_and_isValidEmail(String username, String password, String email, boolean expected) {
        AccountService service = new AccountService();

        boolean emailValid = service.isValidEmail(email);

        boolean registered = service.registerAccount(username, password, email);
        assertEquals(expected, registered,
                () -> "registerAccount unexpected for username=" + username + ", email=" + email);

        if (!emailValid) {
            assertFalse(registered, "Invalid email must not be registered");
        }

        if (registered) {
            assertTrue(emailValid, "Email must be valid when registration succeeds");
            assertNotNull(username, "Username must not be null when registration succeeds");
            assertTrue(username.trim().length() > 3, "Username length must be > 3 when registration succeeds");
        }
    }
    private AccountService service;

    @BeforeAll
    void initOnce() {
        service = new AccountService();
    }

    @ParameterizedTest(name = "[{index}] user={0}, pass={1}, email={2} => expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username,
                             String password,
                             String email,
                             boolean expected) {
        boolean emailValid = service.isValidEmail(email);
        boolean actual = service.registerAccount(username, password, email);

        if (!emailValid) {
            assertFalse(actual, "Email không hợp lệ thì registerAccount phải trả về false");
        }
        assertEquals(expected, actual);
    }
}
