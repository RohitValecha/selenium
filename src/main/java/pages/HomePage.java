package pages;

import org.BaseClass;
import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends CommonFunctions {
    public static  WebElement signInBtn = driver.findElement(By.className("login"));
//    public static List<WebElement> productDetails = driver.findElements(By.className("product-container"));
//    public static  WebElement product= driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));

    public HomePage(WebDriver driver) {

    }

    public Login clickSignIn()
    {
        waitUntilElementAppears(signInBtn);
        signInBtn.click();
        Login log= new Login(driver);
        WebElement EL = log.getEmailId();
        Assert.assertTrue(EL.isDisplayed());
        return new Login(driver);
    }


    public ProductDetails navigateToProductDetails() {

//        WebDriverWait wait = new WebDriverWait(driver,20);
        try{
            WebElement product= driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts'][@itemprop='url'][@class='product-name']"));
            product.click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            WebElement product= driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts'][@itemprop='url'][@class='product-name']" +
                    ""));
            product.click();
        }
        return new ProductDetails(driver);
    }
}
