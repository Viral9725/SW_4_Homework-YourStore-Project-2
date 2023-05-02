package index_demo_com.tutorialninja.pages;

import index_demo_com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class LaptopAndNotebooksPage extends Utility {
    By laptopAndNotebook = By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]");


    public void laptopAndNotBook(){clickOnElement(laptopAndNotebook);  }


}
