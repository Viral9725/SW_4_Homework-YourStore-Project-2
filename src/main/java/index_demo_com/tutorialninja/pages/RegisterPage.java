package index_demo_com.tutorialninja.pages;

import index_demo_com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {
    By registerTab = By.linkText("Register");
    public void registerPageFill(){
       clickOnElement(registerTab);
    }
}
