package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ContactUsPage {
        private Page page;
        //Locators
        private Locator nameTextField;
        private Locator emailTextFiled;
        private Locator subjectTextField;
        private Locator submitBtn;
        private Locator successMsg;

        // Constructor
        public ContactUsPage(Page page) {
            this.page = page;
            initLocators(); // Initialize all locators here
        }

        private void initLocators() {
            nameTextField = page.locator("//input[@name='name']");
            emailTextFiled = page.locator("//input[@name='email']");
            subjectTextField = page.locator("//input[@name='subject']");
            submitBtn = page.locator("//input[@name='submit']");
            successMsg = page.locator("//div[@class='status alert alert-success']");

        }

        //methods

        public void enter_name(){
            nameTextField.fill("xyz");
        }

    public void enter_email(){
        emailTextFiled.fill("abc@g.com");
    }

    public void enter_subject(){
            subjectTextField.fill("testing");
    }
    public void click_on_the_submit_btn(){
            submitBtn.click();
    }

    public void contact_support(){
            enter_name();
            enter_email();
            enter_subject();
        // Set up dialog handler
        page.onceDialog(dialog -> { //- ensures it only listens for the next dialog (for single alert)
            System.out.println("Press OK to proceed!: " + dialog.message());

            // Accept the alert (click OK)
            dialog.accept();

            // If you want to click Cancel instead, use:
            // dialog.dismiss();
        });
        click_on_the_submit_btn();


    }

    public String get_success_msg_text(){
            return successMsg.textContent();
    }






}
