package com.kopicafe.automation.tests;

import com.kopicafe.automation.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Kopi Cafe Login Tests")
public class LoginTest extends BaseTest {

    static LoginPage loginPage;

    @BeforeAll
    static void init() {
        loginPage = new LoginPage(driver);
    }

    // 1️⃣ Chạy các case login sai trước (khi chưa có token)
    @ParameterizedTest(name = "Invalid login: {0} / {1}")
    @Order(1)
    @CsvSource({
            "admin@example.com, wrongpass",
            "wrong@example.com, admin123",
            "'', admin123",
            "admin@example.com, ''"
    })
    @DisplayName("Stay on login page for invalid email/password")
    void loginFail(String email, String password) {
        loginPage.open();                     // /auth/login
        loginPage.login(email, password);     // nhập form

        // Với thông tin sai → không có token → vẫn ở trang auth/login
        loginPage.waitForUrlContains("/auth");
        assertTrue(
                loginPage.isAtLoginPage(),
                "With invalid credentials, user should stay on login page"
        );
    }

    // 2️⃣ Sau đó mới test login thành công
    @Test
    @Order(2)
    @DisplayName("Login successfully with valid account")
    void loginSuccess() {
        loginPage.open();
        loginPage.login("admin@example.com", "admin123");

        // Sau login thành công → /products
        loginPage.waitForUrlContains("/products");
        assertTrue(
                driver.getCurrentUrl().contains("/products"),
                "After successful login, user should be redirected to /products"
        );
    }
}
