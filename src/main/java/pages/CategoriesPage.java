package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CategoriesPage {
        private Page page;
        //Locators
        private Locator topsBtn;
        private Locator categoryTitleText;
        private Locator dressBtn;

        // Constructor
        public CategoriesPage(Page page) {
            this.page = page;
            initLocators(); // Initialize all locators here
        }

        private void initLocators() {
            topsBtn= page.locator("//a[@href='/category_products/2']");
            categoryTitleText= page.locator("(//span[@class='google-anno-t'])[1]");
            dressBtn = page.locator("//a[@href='/category_products/1']");

        }

        public void clickontheTopsBtn(){
            topsBtn.click();
        }

        public String getCategoryTitleText(){
            return categoryTitleText.textContent();
        }

        public void clickontheDressBtn(){
            dressBtn.click();
        }



}
