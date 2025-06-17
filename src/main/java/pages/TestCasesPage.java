package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static utils.BaseTest.teardown;

public class TestCasesPage {
    private Page page;
    private Locator titelText;


    //locators

    //constructor
    public TestCasesPage(Page page) {
        this.page = page;
        initLocators(); // Initialize all locators here
    }


    private void initLocators() {
        titelText= page.locator(" //u[text()='Test Case 1: Register User']");

    }

    public void click_register_user_testcase(){
          titelText.click();

    }


}