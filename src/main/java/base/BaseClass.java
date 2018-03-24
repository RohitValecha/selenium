package base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import pages.HomePage;
import pages.MyAccount;
import utils.TestUtils;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    private static final Logger log= Logger.getLogger(BaseClass.class.getName());
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
        log.info("Starting Browser");
       PropertyConfigurator.configure("C:\\Github\\backup\\selenium\\src\\main\\resources\\log4j.properties");
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
       driver.getTitle();
       driver.navigate().to(prop.getProperty("url"));
        log.info("Browser Setup Done");
    }

    public MyAccount Login(){
        initialization();
        log.info("Starting Login");
        home = new HomePage();
        home.clickSignIn()
                .Login(prop.getProperty("username"),prop.getProperty("password"));
        log.info("Login Done");
        return new MyAccount();
    }

    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }



}



