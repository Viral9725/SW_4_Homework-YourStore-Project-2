package index_demo_com.tutorialninja.pages;

import index_demo_com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By loginButton = By.xpath("//a[normalize-space()='Login']");
    By newCustomer = By.xpath("//a[@class='btn btn-primary']");
    By emailField = By.id("Email");
    By passwordField = By.name("Password");
    By errorMessage = By.xpath("//div[@class='message-error validation-summary-errors']");

    public void enterEmailId(String email){
        sendTextToElement(emailField, email);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordField, password);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public String getErrorMessage(){
        return getTextFromElement(errorMessage);
    }
    public void newCustomerPage() { clickOnElement(newCustomer); }

}
