package pages;

import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfirmOrder extends CommonFunctions
{

            public static WebElement confirmOrder=driver.findElement(By.xpath("//button[contains (@class,'medium') and @type ='submit']"));

    public ConfirmOrder confirmOrder(){

        waitUntilElementAppears(confirmOrder);
        confirmOrder.click();
        return this;
    }
}
