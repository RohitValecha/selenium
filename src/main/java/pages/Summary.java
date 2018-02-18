package pages;

import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Summary extends CommonFunctions {

    public static WebElement checkoutBtn=driver.findElement(By.xpath("//a[contains(@href,'step=1')][@title='Proceed to checkout']"));

    public Address checkOutSummary(){
        waitUntilElementAppears(checkoutBtn);
        checkoutBtn.click();
        return new Address();
    }
}
