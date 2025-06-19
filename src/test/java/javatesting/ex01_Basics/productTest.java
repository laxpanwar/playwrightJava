package javatesting.ex01_Basics;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.BaseTest;
import utils.ConfigReader;

public class productTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductPage productPage;
    private CategoriesPage categoriesPage;


    @BeforeClass
    public void init() {
        setup();
        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);

    }

    @Test
    public void addToCart(){
        String baseUrl = ConfigReader.get("url");
        loginPage.navigateTo(baseUrl);
        homePage = loginPage.loginValidCredentials();
        //productPage = homePage.clickOnTheProductBtn();
        //Assert.assertEquals(ProductPage.getAddedTex(),"Your product has been added to cart.");
        categoriesPage = homePage.clickontheWomenBtn();
        categoriesPage.clickontheTopsBtn();
        productPage.addProductsToAddToCart();
    }

    @AfterClass
    public void cleanup() {
        teardown();
    }

}


