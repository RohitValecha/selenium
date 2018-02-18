package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class BaseClass {

    public static WebDriver driver;


    public HomePage openURL()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AMIT\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to(Constants.URL);
        driver.manage().window().maximize();
        return new HomePage(driver);
    }


    public static void afterClass()
    {

        driver.quit();
    }
}
