package pages;

import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Payment extends CommonFunctions
{
    public static WebElement payByBankwire= driver.findElement(By.xpath("//a[@class='bankwire']"));

    public ConfirmOrder payment(){
        payByBankwire.click();
        return new ConfirmOrder();
    }
}
