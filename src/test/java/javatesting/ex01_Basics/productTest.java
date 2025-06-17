package javatesting.ex01_Basics;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.BaseTest;
import utils.ConfigReader;

public class productTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductPage productPage;


    @BeforeClass
    public void init() {
        setup();
        loginPage = new LoginPage(page);
    }

    @Test
    public void addToCart(){
//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        Page page = browser.newPage();
        String baseUrl = ConfigReader.get("url");
        String email = ConfigReader.get("email");
        String password = ConfigReader.get("password");

        loginPage.navigateTo(baseUrl);
//        System.out.println(page.title());
        homePage =  loginPage.login(email, password );
        productPage = homePage.clickOnTheProductBtn();
        Assert.assertEquals(ProductPage.getAddedText(),"Your product has been added to cart.");



    }

    @AfterClass
    public void cleanup() {
        teardown();
    }

}


