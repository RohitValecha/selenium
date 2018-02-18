package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions extends BaseClass {

    public void waitUntilElementAppears(WebElement Element)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    public void waitUntilStaleElementAppears(WebElement Element)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.stalenessOf(Element));
    }

    public void scrollToElement (WebElement Element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(Element).perform();
    }

    public void hover (WebElement Element){
        Actions actions = new Actions(driver);
        actions.moveToElement(Element).perform();
    }
}
