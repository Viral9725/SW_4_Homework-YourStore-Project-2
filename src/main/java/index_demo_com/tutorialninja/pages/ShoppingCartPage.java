package index_demo_com.tutorialninja.pages;

import index_demo_com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By shoppingCart = By.xpath("//button[@id='button-cart']");
    public void addToCart() {
        clickOnElement(shoppingCart);
    }
}
