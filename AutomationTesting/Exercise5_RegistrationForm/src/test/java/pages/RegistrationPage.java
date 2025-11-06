package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    // 1. Constructor: Phải gọi super(driver) để BasePage có driver
    public RegistrationPage(WebDriver driver) {
        super(driver); // [cite: 163]
    }

    // 2. Locators: Định nghĩa tất cả các element bạn cần
    // Bạn cần tự tìm các ID, CSS, hoặc XPath cho trang demoqa.com [cite: 211]
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderMaleRadio = By.xpath("//label[text()='Male']"); // (Ví dụ XPath)
    private By mobileField = By.id("userNumber");
    private By dobField = By.id("dateOfBirthInput");
    private By subjectsField = By.id("subjectsInput");
    private By hobbiesCheckbox = By.xpath("//label[text()='Sports']"); // (Ví dụ XPath)
    private By pictureUpload = By.id("uploadPicture");
    private By addressField = By.id("currentAddress");
    private By stateDropdown = By.id("state");
    private By cityDropdown = By.id("city");
    private By submitButton = By.id("submit");
    private By successModalHeader = By.id("example-modal-sizes-title-lg");

    // 3. Actions: Các hàm để test class gọi đến

    /**
     * Điều hướng đến trang đăng ký
     */
    public void navigate() {
        // Sử dụng hàm tiện ích từ BasePage [cite: 166, 158]
        navigateTo("https://demoqa.com/automation-practice-form");
    }

    /**
     * Nhập thông tin và submit
     * (Đây là một ví dụ, bạn có thể tách ra nhiều hàm nhỏ)
     */
    public void fillForm(String firstName, String lastName, String email, String mobile, String address) {
        // Sử dụng các hàm tiện ích từ BasePage [cite: 167, 156]
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(emailField, email);
        jsClick(genderMaleRadio);
        type(mobileField, mobile);
        type(addressField, address);
        // ... (bạn cần thêm xử lý cho các trường khác như date, upload, dropdown)
    }

    /**
     * Nhấn nút submit
     */
    public void submit() {
        jsClick(submitButton);
    }

    /**
     * Lấy locator của modal
     */
    public By getSuccessModalHeaderLocator() {
        return successModalHeader; // [cite: 168]
    }

    /**
     * Lấy text từ modal (nếu cần)
     */
    public String getModalHeaderText() {
        return getText(successModalHeader); // [cite: 170, 157]
    }
}