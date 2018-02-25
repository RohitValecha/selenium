package pages;

import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Summary extends CommonFunctions {

    //OR
    @FindBy(xpath = "//a[contains(@href,'step=1')][@title='Proceed to checkout']")
    WebElement checkOutBtn;

    //Initialization
    public Summary() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public Address checkOutSummary() {
        clickAfterElementAppears(checkOutBtn);
        return new Address();
    }
}
