package index_demo_com.tutorialninja.testsuite;

import index_demo_com.tutorialninja.pages.*;
import index_demo_com.tutorialninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class LoginTest extends BaseTest {

    CheckoutPage checkoutPage = new CheckoutPage();
    ComponentsPage components = new ComponentsPage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopAndNotebooksPage laptopAndNotebooksPage = new LaptopAndNotebooksPage();
    LoginPage loginPage = new LoginPage();

    RegisterPage registerPage = new RegisterPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        laptopAndNotebooksPage.clickOnElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        // 1.2 Click on “Show All Laptops & Notebooks”
        laptopAndNotebooksPage.clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        // 1.3 Select Sort By "Price (High > Low)"
        mouseHoverOnElement(By.xpath("//label[contains(text(),'Sort By:')]"));
        laptopAndNotebooksPage.clickOnElement(By.xpath("//option[contains(text(),'Name (A - Z)')]"));
        // 1.4 Verify the Product price will arrange in High to Low order.
        laptopAndNotebooksPage.clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        assertVerifyText(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price (High > Low)");
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        laptopAndNotebooksPage.clickOnElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        // 2.2 Click on “Show All Laptops & Notebooks”
        laptopAndNotebooksPage.clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        // 2.3 Select Sort By "Price (High > Low)"
        laptopAndNotebooksPage.mouseHoverOnElement(By.xpath("//label[contains(text(),'Sort By:')]"));
        laptopAndNotebooksPage.clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        //2.4 Select Product “MacBook”
        laptopAndNotebooksPage.clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        // 2.5 Verify the text “MacBook”
        laptopAndNotebooksPage.assertVerifyText(By.xpath("//h1[normalize-space()='MacBook']"), "MacBook");
        // 2.6 Click on ‘Add To Cart’ button
        laptopAndNotebooksPage.clickOnElement(By.xpath("//button[@id='button-cart']"));
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!
        assertVerifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!");
        // 2.8 Click on link “shopping cart” display into success message
        shoppingCartPage.clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // 2.9 Verify the text "Shopping Cart"
        assertVerifyText(By.xpath("//a[normalize-space()='shopping cart'],'shopping cart')]"), "shopping cart");
        // 2.10 Verify the Product name "MacBook"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");
        // 2.11 Change Quantity "2"
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        // 2.12 Click on “Update” Tab
        shoppingCartPage.clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]"));
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        assertVerifyText(By.xpath("//body/div[@id='checkout-cart']/div[1]"), "Success: You have modified your shopping cart!");
        // 2.14 Verify the Total £737.45
        assertVerifyText(By.xpath("//tbody/tr[1]/td[6]"), "$1,204.00");
        // 2.15 Click on “Checkout” button
        checkoutPage.clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        // 2.16 Verify the text “Checkout”
        assertVerifyText(By.xpath("//a[contains(text(),'Checkout')]"), "Checkout");
        // 2.17 Verify the Text “New Customer”
        assertVerifyText(By.xpath("//h2[contains(text(),'New Customer')]"), "New Customer");
        // 2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]"));
        // 2.19 Click on “Continue” tab
        checkoutPage.clickOnElement(By.xpath("//input[@id='button-account']"));
        // 2.20 Fill the mandatory fields
        checkoutPage.clickOnElement(By.xpath("//input[@id='input-payment-firstname']"));
        checkoutPage.sendTextToElement(By.name("firstname"), "viral");
        checkoutPage.sendTextToElement(By.name("lastname"), "patel");
        checkoutPage.sendTextToElement(By.name("email"), "viral123456@gmail.com");
        checkoutPage.sendTextToElement(By.name("//input[@id='input-payment-telephone']"), "07875795650");
        checkoutPage.sendTextToElement(By.id("input-payment-city"), "London");
        checkoutPage.sendTextToElement(By.id("postcode"), "SW0 92Y");
        checkoutPage.sendTextToElement(By.id("BillingNewAddress_Address1"), "10 street");
        checkoutPage.sendTextToElement(By.id("input-payment-postcode"), "NW10 R74");
        checkoutPage.clickOnElement(By.id("BillingNewAddress_CountryId"));
        checkoutPage.selectByValueFromDropDown(By.id("input-payment-country"), "United Kingdom");
        checkoutPage.selectByValueFromDropDown(By.id("input-payment-zone"), "Greater London");
        checkoutPage.selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']']"), "Greater London");
        // 2.21 Click on “Continue” Button
        checkoutPage.clickOnElement(By.xpath("//input[@id='button-guest']"));
        // 2.22 Add Comments About your order into text area
        checkoutPage.sendTextToElement(By.xpath("//textarea[@name='comment']"), "Hello,tutorials ninja?");
        // 2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnElement(By.xpath("//input[@name='agree']"));
        // 2.24 Click on “Continue” button
        checkoutPage.clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        // 2.25 Verify the message “Warning: Payment method required!”
        assertVerifyText(By.xpath("//div[@class='alert alert-danger alert-dismissible']"), "Warning: Payment method required!");
    }
    // Use the WebDriver instance to find and click the menu based on its name
    public void selectMenu(String menu) {
        driver.findElement(By.xpath("//nav[@id='menu'], '" + menu + "')]")).click();
        Assert.assertEquals("Correct page is not displayed", menu, driver.findElement(By.xpath("//nav[@id='menu'],'" + menu + "')]")).getText());
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        desktopPage.clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        desktopPage.clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Assert.assertEquals("Desktops not displayed", "Desktops not displayed", driver.findElement(By.xpath("//h2[contains(text(),'Desktops')]")).getText());
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        laptopAndNotebooksPage.clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        laptopAndNotebooksPage.clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks'])[1]"));
        selectMenu("Show All Laptops & Notebooks");
        Assert.assertEquals("Laptops & Notebooks page not displayed", "Laptops & Notebooks", driver.findElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]")).getText());
        driver.findElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")).click();
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        components.clickOnMouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        //3.2 call selectMenu method and pass the menu = “Show All Components
        components.clickOnMouseHoverOnElement(By.xpath("//a[contains(text(),'Show AllComponents')]"));
        // 3.3 Verify the text ‘Components’
        Assert.assertEquals("Components page not displayed", "Components page not displayed", driver.findElement(By.xpath("//h2[contains(text(),'Components')]")).getText());
    }

    public void selectMyAccountOptions(String option) throws InterruptedException {
        //Generic X-path for Options navigation
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        clickOnElement(By.xpath("(//a[normalize-space()='" + option + "'])[1]"));
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        selectMyAccountOptions("Register");
        Thread.sleep(1000);
        String expectedMsg = "Register Account";
        String actualMsg = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        Assert.assertEquals(actualMsg, expectedMsg, "The expected text is not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        selectMyAccountOptions("Login");
        // Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
    }
    String email;
    String password = "Abcd1234";

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        selectMyAccountOptions("Register");

        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Michael");
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Vine");
        sendTextToElement(By.xpath("//input[@id='input-email']"), email);
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "07788995566");
        sendTextToElement(By.xpath("//input[@id='input-password']"), password);
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), password);

        registerPage.clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        registerPage.clickOnElement(By.xpath("//input[@name='agree']"));
        registerPage.clickOnElement(By.xpath("//input[@value='Continue']"));
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Your " + "Account Has Been Created!']"));
      //  assertVerifyText("The expected text is not displayed", expectedMessage, actualMessage);

        registerPage.clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        selectMyAccountOptions("Logout");
        String expectedMes1 = "Account Logout";
        String actualMes = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
//        assertVerifyText("The expected text is not displayed", "expectedMes1", actualMes);
        registerPage.clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        selectMyAccountOptions("Login");
        loginPage.sendTextToElement(By.xpath("//input[@id='input-email']"), "viral123@gmail.com");
        loginPage.sendTextToElement(By.xpath("//input[@id='input-password']"), "viral123");
        loginPage.clickOnElement(By.xpath("//input[@value='Login']"));
        String expectedMes = "My Account";
        String actualMes = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
       //assertVerifyText("The expected text is not displayed", expectedMes, actualMes);

        selectMyAccountOptions("Logout");
        String expectedMessage = "Account Logout";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        // assertVerifyText("The expected text is not displayed", expectedMessage, actualMessage);
        loginPage.clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }
}
