package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.time.Duration;
import java.util.List;

/**
 * Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in alphabetical order
 * 2. verifyTheSortByPriceFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Price”
 * * Verify the products price display in Low to High
 */
public class WomenTest extends Utility {
    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        // Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        // Click on Jackets
        mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        // Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"),("Price"));
        // Verify the products name display in alphabetical order
        List<WebElement> elements = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        String expectedText = "12 Items";
        String actualText = driver.findElement(By.xpath("(//div[@class='toolbar toolbar-products']//p[@id='toolbar-amount'])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        // Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        // Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        // Click on Jackets
        mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price");
        // Verify the products price display in Low to High
        List<WebElement> List2 = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        for (int i = 0; i < List2.size(); i++) {
            System.out.println(List2.get(i).getText());
            String exp = List2.get(i).getText();
            String actual = List2.get(i).getText();
            Assert.assertEquals("Price not ordered : Low to High ", exp, actual);
        }

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
