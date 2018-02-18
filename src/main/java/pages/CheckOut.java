package pages;

import org.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut extends CommonFunctions {

    public static WebElement checkoutBtn=driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));

    public CheckOut(WebDriver driver) {
        this.driver=driver;
    }


    public Summary checkout() {
        waitUntilElementAppears(checkoutBtn);
        checkoutBtn.click();
        return new Summary();
    }

}
