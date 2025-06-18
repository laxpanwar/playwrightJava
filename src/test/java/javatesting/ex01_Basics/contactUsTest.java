package javatesting.ex01_Basics;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.BaseTest;
import utils.ConfigReader;

public class contactUsTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductPage productPage;
    private ContactUsPage contactUsPage;


    @BeforeClass
    public void init() {
        setup();
        loginPage = new LoginPage(page);
    }

    @Test
    public void contactSupport() {
        String baseUrl = ConfigReader.get("url");
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");

        loginPage.navigateTo(baseUrl);
        homePage = loginPage.login(email, password);
        contactUsPage = homePage.clickontheContactUsBtn();
        contactUsPage.contact_support();
        Assert.assertEquals(contactUsPage.get_success_msg_text(),"Success! Your details have been submitted successfully.");
    }

    @AfterClass
    public void cleanup() {
        teardown();
    }
}
