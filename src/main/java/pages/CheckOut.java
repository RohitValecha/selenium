package pages;

import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckOut extends CommonFunctions {

    //OR
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement checkoutBtn;

    //Initialization
    public  CheckOut(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public Summary checkout(){
        clickAfterElementAppears(checkoutBtn);
        return new Summary();
    }
}
