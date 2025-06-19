package javatesting.ex01_Basics;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.ConfigReader;

public class loginTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;



    @BeforeClass
    public void init() {
        setup();
        loginPage = new LoginPage(page);
    }

    @Test
    public void testLoginValidUser(){
        String baseUrl = ConfigReader.get("url");
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");

        loginPage.navigateTo(baseUrl);
        loginPage.login(email, password );
        Assert.assertEquals(loginPage.getLogoutText()," Logout");
    }

    @Test
    public void testLoginInvalidEmail(){
        String baseUrl = ConfigReader.get("url");
        loginPage.navigateTo(baseUrl);
        homePage = loginPage.loginValidCredentials();
        Assert.assertEquals(loginPage.getInvalidValidationMsg(),"Your email or password is incorrect!");
    }

    @AfterClass
    public void cleanup() {
        teardown();
    }

}
