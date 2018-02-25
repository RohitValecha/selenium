package pages;

import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends CommonFunctions {

    //OR
    @FindBy(id = "header_logo")
    WebElement logo;

    @FindBy(className = "logout")
    WebElement logout;

    //Initialization

    public MyAccount(){
        PageFactory.initElements(driver, this);
    }

    //Actions

    public HomePage navigateToHome()
    {
        clickAfterElementAppears(logo);
        return new HomePage();
    }
}
