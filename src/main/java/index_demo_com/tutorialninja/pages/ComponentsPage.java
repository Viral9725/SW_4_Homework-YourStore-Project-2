package index_demo_com.tutorialninja.pages;

import index_demo_com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {

    By components = By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]");

    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
         clickOnElement(components);
    }
}
