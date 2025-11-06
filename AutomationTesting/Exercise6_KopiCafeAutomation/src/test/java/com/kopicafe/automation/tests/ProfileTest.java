package com.kopicafe.automation.tests;

import com.kopicafe.automation.pages.LoginPage;
import com.kopicafe.automation.pages.ProfilePage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Kopi Cafe Profile Tests")
public class ProfileTest extends BaseTest {

    static LoginPage loginPage;
    static ProfilePage profilePage;

    @BeforeAll
    static void init() {
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("Redirect to login when accessing profile without login")
    void profileWithoutLoginRedirectsToLogin() {
        // Chưa login, truy cập /profile
        profilePage.open();

        // CheckAuth sẽ Navigate sang /auth/login
        loginPage.waitForUrlContains("/auth/login");

        assertTrue(
                loginPage.isAtLoginPage(),
                "User should be redirected to login page when accessing /profile without login"
        );
    }

    @Test
    @Order(2)
    @DisplayName("Show profile info when user is logged in")
    void profileVisibleWhenLoggedIn() {
        // Login trước
        loginPage.open();
        loginPage.login("admin@example.com", "admin123");
        loginPage.waitForUrlContains("/products");

        // Mở profile
        profilePage.open();
        profilePage.waitForUrlContains("/profile");

        assertTrue(
                profilePage.isProfileVisible(),
                "Profile page should be visible for logged-in user"
        );
    }
}
