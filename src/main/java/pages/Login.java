package pages;

import org.BaseClass;
import org.CommonFunctions;
import org.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login extends CommonFunctions {

    public static WebElement emailId = driver.findElement(By.id("email"));
    public static WebElement pssword = driver.findElement(By.id("passwd"));
    public static  WebElement submitLogin = driver.findElement(By.id("SubmitLogin"));
    public static List<WebElement> myAccountOptions = driver.findElements(By.className("myaccount-link-list"));

    public Login(WebDriver driver) {
        super();
    }

    public MyAccount Login(String username,String password)
    {
        System.out.println("Inside Login");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Assert.assertTrue(emailId.isDisplayed());
        waitUntilElementAppears(emailId);
        emailId.sendKeys(username);
        pssword.sendKeys(password);
        submitLogin.click();
        return new MyAccount(driver);
    }

    public WebElement getEmailId() {
        return emailId;
    }
}
