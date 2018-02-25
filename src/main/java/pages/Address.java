package pages;

import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address extends CommonFunctions {


    //OR
    @FindBy(xpath = "//button[@type='submit' and @name='processAddress']")
    WebElement checkoutBtn;

    //Initialization
    public  Address(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public ShippingAddress checkOutAddress(){
        clickAfterElementAppears(checkoutBtn);
        return new ShippingAddress();
    }
}
