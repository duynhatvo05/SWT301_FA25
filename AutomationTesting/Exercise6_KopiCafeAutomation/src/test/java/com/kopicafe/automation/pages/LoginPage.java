package com.kopicafe.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Cho phép override bằng -DbaseUrl=..., mặc định localhost:3000
    private static final String BASE_URL =
            System.getProperty("baseUrl", "http://localhost:3000")
                    .replaceAll("/$", "");

    private By emailField    = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton   = By.xpath("//button[normalize-space()='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        // FE route login: /auth/login
        navigateTo(BASE_URL + "/auth/login");
    }

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
    }

    /** Đang đứng đúng trang login hay không */
    public boolean isAtLoginPage() {
        return driver.getCurrentUrl().contains("/auth/login")
                && isElementVisible(emailField)
                && isElementVisible(passwordField);
    }
}
