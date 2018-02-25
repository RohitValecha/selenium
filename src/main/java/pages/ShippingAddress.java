package pages;

import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddress extends CommonFunctions {

    //OR
    @FindBy(xpath = "//button[@type='submit' and @name='processCarrier']")
    WebElement checkoutBtn;

    @FindBy(id = "uniform-cgv")
    WebElement checkBox;

    //Initialization
    public  ShippingAddress(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public Payment checkOutShipping(){
        clickAfterElementAppears(checkBox);
        clickAfterElementAppears(checkoutBtn);
        return new Payment();
    }
}
