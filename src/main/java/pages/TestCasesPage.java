package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static utils.BaseTest.teardown;

public class TestCasesPage {
    private Page page;
    //locators
    private Locator titelText;
    private Locator testCasesList;

    //constructor
    public TestCasesPage(Page page) {
        this.page = page;
        initLocators(); // Initialize all locators here
    }

    private void initLocators() {
        titelText= page.locator(" //u[text()='Test Case 1: Register User']");
        testCasesList= page.locator("(//div[@class='panel-group'])[25]");

    }

    public void click_register_user_testcase(){
          titelText.click();

    }

    public void clickEachTestCase(){
//        // Get the count of test case elements
//        int count = testCasesList.count();
//
//        // Loop through each element and click
//        for (int i = 0; i < count; i++) {
//            testCasesList.scrollIntoViewIfNeeded();
//            testCasesList.nth(i).click(); // Click each test case element
//            page.waitForLoadState();
//            System.out.println(page.locator("//div[@class='panel-group']").count());
//            page.waitForLoadState();  // Ensure page loads after click
           // page.goBack();            // Navigate back after clicking
            testCasesList.scrollIntoViewIfNeeded();
            testCasesList.click();
    }



}