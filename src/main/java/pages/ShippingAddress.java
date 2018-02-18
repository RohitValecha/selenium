package pages;

import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShippingAddress extends CommonFunctions{

    public static WebElement checkoutBtn=driver.findElement(By.xpath("//button[@type='submit' and @name='processCarrier']"));
    public static WebElement checkBox=driver.findElement(By.id("uniform-cgv"));


    public Payment checkOutShipping(){
        checkBox.click();
        waitUntilElementAppears(checkoutBtn);
        checkoutBtn.click();
        return new Payment();
    }
}
