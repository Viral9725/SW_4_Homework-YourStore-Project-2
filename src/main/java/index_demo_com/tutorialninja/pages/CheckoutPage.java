package index_demo_com.tutorialninja.pages;

import index_demo_com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {
    By loginLink = By.linkText("Log in");
    By registerLink = By.linkText("Register");

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }


}
