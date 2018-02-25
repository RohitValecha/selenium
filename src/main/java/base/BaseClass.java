package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.MyAccount;
import utils.TestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;
    public HomePage home;

    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Selenium\\src\\main\\java\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){
       String browserName= prop.getProperty("browser");
       if (browserName.equalsIgnoreCase("CHROME")){
           System.setProperty("webdriver.chrome.driver","C:\\Users\\AMIT\\Downloads\\chromedriver_win32\\chromedriver.exe");
           driver = new ChromeDriver();
           }
           else if (browserName.equalsIgnoreCase("Mozilla")){
           System.setProperty("webdriver.gecko.driver","C:\\Users\\AMIT\\Downloads\\chromedriver_win32\\chromedriver.exe");
           driver= new FirefoxDriver();
       }
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(TestUtils.pageLoadTimeout,TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(TestUtils.implicitWait, TimeUnit.SECONDS);

       driver.navigate().to(prop.getProperty("url"));
    }

    public MyAccount Login(){
        initialization();
        home = new HomePage();
        home.clickSignIn()
                .Login(prop.getProperty("username"),prop.getProperty("password"));
        return new MyAccount();
    }

    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }



}



