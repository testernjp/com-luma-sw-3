package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * Write down the following test into ‘GearTest’ class
 * 1. userShouldAddProductSuccessFullyToShoppingCart()
 * Mouse Hover on Gear Menu
 * Click on Bags
 * Click on Product Name ‘Overnight Duffle’
 * Verify the text ‘Overnight Duffle’
 * Change Qty 3
 * Click on ‘Add to Cart’ Button.
 * Verify the text ‘You added Overnight Duffle to your shopping cart.’
 * Click on ‘shopping cart’ Link into message
 * Verify the product name ‘Cronus Yoga Pant’
 * Verify the Qty is ‘3’
 * Verify the product price ‘$135.00’
 * Change Qty to ‘5’
 * Click on ‘Update Shopping Cart’ button
 * Verify the product price ‘$225.00’
 */
public class GearTest extends Utility {
    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//a[@class='level-top ui-corner-all']//span[normalize-space()='Gear']"));
        // Click on Bags
        mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-25']//span[normalize-space()='Bags']"));
        // Click on Product Name ‘Overnight Duffle’
        mouseHoverToElementAndClick(By.xpath("//a[@class='product-item-link'][normalize-space()='Overnight Duffle']"));
        // Verify the text ‘Overnight Duffle’
        verifyTextFromElement(By.xpath("//span[@class='base']"), "Overnight Duffle");
        // Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"), Keys.DELETE + "3");
        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyTextFromElement(By.xpath("//div[@class='message-success success " +
                "message']"), "You added Overnight Duffle to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the product name ‘Overnight Duffle’
        verifyTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"), "Overnight Duffle");
        // Verify the Qty is ‘3’
        Thread.sleep(3000);
        List<WebElement> qty3 = driver.findElements(By.xpath("//div[@class='control qty']"));
        for (WebElement c :qty3) {
            System.out.println(c.getText());
        }
        // Verify the product price ‘$135.00’
        verifyTextFromElement(By.xpath("//span[@class='cart-price']//span[contains(text(),'$135.00')]"), "$135.00");
        // Change Qty to ‘5’
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='3']")).clear();
        sendTextToElement(By.xpath("//input[@value='3']"), "5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        // Verify the product price ‘$225.00’
        verifyTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price']" +
                "[text()='$225.00']"), "$225.00");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
