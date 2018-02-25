package pages;

import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrder extends CommonFunctions {
    //OR
    @FindBy(xpath = "//button[contains (@class,'medium') and @type ='submit']")
    WebElement confirmOrder;

    //Initialization
    public  ConfirmOrder(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public ConfirmOrder confirmOrder(){
        clickAfterElementAppears(confirmOrder);
        return this;
    }
}
