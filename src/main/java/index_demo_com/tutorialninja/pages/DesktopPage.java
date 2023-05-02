package index_demo_com.tutorialninja.pages;

import index_demo_com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class DesktopPage extends Utility {
   By deskTopPage = By.xpath("(//a[normalize-space()='Desktops'])[1]");

   public void clickOnLoginPage(){
       clickOnElement(deskTopPage);
   }

}
