package pages;

import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment extends CommonFunctions {
    //OR
    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement payByBankWire;

    //Initialization
    public  Payment(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public ConfirmOrder payment(){
        clickAfterElementAppears(payByBankWire);
        return new ConfirmOrder();
    }
}
