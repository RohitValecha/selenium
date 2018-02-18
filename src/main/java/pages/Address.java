package pages;

import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Address extends CommonFunctions {

    public static WebElement checkoutBtn=driver.findElement(By.xpath("//button[@type='submit' and @name='processAddress']"));

    public ShippingAddress checkOutAddress(){
        waitUntilElementAppears(checkoutBtn);
        checkoutBtn.click();
        return new ShippingAddress();
    }
}
