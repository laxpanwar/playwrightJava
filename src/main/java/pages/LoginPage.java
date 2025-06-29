package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.ConfigReader;

public class LoginPage {

    private Page page;
    // Locators
    private Locator usernameInput;
    private Locator passwordInput;
    private Locator loginButton;
    private Locator loginLink;
    private Locator logoutBtn;
    private Locator InvalidValidationMsg;


    // Constructor
    public LoginPage(Page page) {
        this.page = page;
        initLocators(); // Initialize all locators here
    }

    private void initLocators() {
        usernameInput = page.locator("//input[@data-qa='login-email']");
        passwordInput = page.locator("//input[@data-qa='login-password']");
        loginButton = page.locator("//button[@data-qa='login-button']");
        loginLink = page.locator("//a[@href='/login']");
        logoutBtn = page.locator("//a[normalize-space()='Logout']");
        InvalidValidationMsg= page.locator(" //p[@style='color: red;']");
    }



    // Actions
    public void navigateTo(String url) {
//        String baseUrl = ConfigReader.get("url");
        page.navigate(url); // Replace with actual URL
    }

    public void clickOnLoginLink(){
        loginLink.click();
    }

    public void enterUserEmail(String username) {
        usernameInput.fill(username);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public HomePage login(String username, String password) {
        clickOnLoginLink();
        enterUserEmail(username);
        enterPassword(password);
        clickLogin();
        return new HomePage(page);

    }

    public HomePage  loginValidCredentials(){
//        String baseUrl = ConfigReader.get("url");
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");
        clickOnLoginLink();
        enterUserEmail(email);
        enterPassword(password);
        clickLogin();
        return new HomePage(page);
    }


    public String getLogoutText(){
        return logoutBtn.textContent();
    }

    public String getInvalidValidationMsg(){
        return InvalidValidationMsg.textContent();
    }

}
