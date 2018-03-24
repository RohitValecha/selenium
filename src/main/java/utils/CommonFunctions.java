package utils;

import base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonFunctions extends BaseClass {

    public void clickAfterElementAppears(WebElement Element)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(Element));
        try
        {
            Element.click();
        }catch(Exception e){
                System.out.println("Exception while clicking element occured :" + e);
            }
    }

    public void clickOnOneElementAndAssertOnAnotherElement(WebElement Element1, WebElement Element2){
        clickAfterElementAppears(Element1);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(Element2));
    }

    public void waitUntilElementAppears(WebElement Element){
        if (Element.isDisplayed()==true){
            return;
        }else{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(Element));
        }
    }

    public void clickProduct(String productName){
        WebElement productElement = driver.findElement(By.xpath("//a[@title='"+productName+"'][@itemprop='url'][@class='product-name']"));
//        clickViaJS(productElement,driver);
        for (int i=0;i<=4;i++) {
            try {
                productElement.click();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Recovering from StaleElement Exception" + e);
            }
        }
    }

    public WebElement getProduct(String productName){
        WebElement productElement = driver.findElement(By.xpath("//a[@title='"+productName+"'][@itemprop='url'][@class='product-name']"));
        return productElement;
    }

    public void waitUntilStaleElementAppears(WebElement Element)
    {
        for (int i=0; i<=3;i++) {
            try {
                Element.isDisplayed();
            } catch (StaleElementReferenceException e) {
                System.out.println("Reovering From Stale Element" + e);
            }
        }
//        WebDriverWait wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.stalenessOf(Element));
    }

    public void clickViaJS (WebElement Element, WebDriver driver)
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();",Element);
    }


    public void hover (WebElement Element){
        Actions actions = new Actions(driver);
        actions.moveToElement(Element).perform();
    }
}
