package pages;

import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetails extends CommonFunctions{

    public ProductDetails(WebDriver driver){
        this.driver=driver;
    }

    public static WebElement add2CartBtn= driver.findElement(By.id("add_to_cart"));

    public CheckOut add2Cart() {

        waitUntilElementAppears(add2CartBtn);
        add2CartBtn.click();
        return new CheckOut(driver);
    }

}
