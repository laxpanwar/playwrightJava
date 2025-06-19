package javatesting.ex01_Basics;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TestCasesPage;
import utils.BaseTest;
import utils.ConfigReader;

public class testCasesTest extends BaseTest {
        private LoginPage loginPage;
        private HomePage homePage;
        private TestCasesPage testCasesPage;


        @BeforeClass
        public void init () {
            setup();
            loginPage = new LoginPage(page);
        }

        @Test
        public void testCases () {
            String baseUrl = ConfigReader.get("url");
            loginPage.navigateTo(baseUrl);
            homePage = loginPage.loginValidCredentials();
            testCasesPage = homePage.clickontheTestCaseBtn();
            testCasesPage.clickEachTestCase();
        }
    @AfterClass
    public void cleanup() {
        teardown();
    }

    }

