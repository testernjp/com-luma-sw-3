package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in it’.
 */
public class Utility extends BaseTest {

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        WebElement action = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(action).build().perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        WebElement action = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(action).click().perform();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will select option from drop down menu
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void verifyTextFromElement(By by, String expectedText) {
        WebElement actualText = driver.findElement(by);
        String actual = actualText.getText();
        Assert.assertEquals(expectedText, actual);
    }

}
