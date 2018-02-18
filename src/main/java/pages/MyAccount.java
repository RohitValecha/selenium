package pages;

import org.BaseClass;
import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount extends CommonFunctions {

    public static WebElement logo= driver.findElement(By.id("header_logo"));
    public static WebElement logout = driver.findElement(By.className("logout"));

    public HomePage navigateToHome()
    {
        waitUntilElementAppears(logo);
        logo.click();
        return new HomePage(driver);
    }

    public void Logout() {
        waitUntilElementAppears(logout);
        logout.click();
    }

    public MyAccount(WebDriver driver)
    {
        this.driver= driver;
    }
}
