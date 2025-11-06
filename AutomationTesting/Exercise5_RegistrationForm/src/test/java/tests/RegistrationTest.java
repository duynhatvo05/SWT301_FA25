package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegistrationPage; // Import lớp bạn vừa tạo

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals; // Thêm assertEquals

@DisplayName("Registration Form Tests")
public class RegistrationTest extends BaseTest { // [cite: 185, 189]

    static RegistrationPage registrationPage;
    static WebDriverWait wait;

    // 1. Khởi tạo Page Object trước khi chạy test
    // Sử dụng @BeforeAll giống hệt Bài 4 [cite: 191]
    @BeforeAll
    static void initPage() {
        // 'driver' được kế thừa từ BaseTest
        registrationPage = new RegistrationPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // [cite: 192]
    }

    // 2. Viết Test Case
    @Test
    @DisplayName("Should submit form successfully with valid data")
    void testSuccessfulRegistration() {
        // 1. Arrange / Act
        registrationPage.navigate(); // [cite: 193]
        registrationPage.fillForm(
                "John",
                "Doe",
                "john.doe@example.com",
                "1234567890",
                "123 Main St"
                // ... thêm các dữ liệu khác
        );
        registrationPage.submit(); // [cite: 194]

        // 2. Assert
        // Chờ modal xác nhận hiển thị [cite: 194]
        WebElement successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                registrationPage.getSuccessModalHeaderLocator()
        ));

        // Kiểm tra nội dung
        String headerText = successModal.getText();
        assertTrue(headerText.contains("Thanks for submitting the form"),
                "Modal header text is incorrect!"); // [cite: 194]
    }

    // Bạn có thể thêm các test case khác (ví dụ: submit khi thiếu trường)
    @Test
    @DisplayName("Should show validation errors when required fields are empty")
    void testEmptySubmission() {
        registrationPage.navigate();
        registrationPage.submit(); // Không điền gì cả

        // ... (Viết code assert để kiểm tra viền đỏ hoặc thông báo lỗi)
        // Ví dụ: assertTrue(registrationPage.isFirstNameErrorVisible());
    }
}