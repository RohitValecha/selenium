package pages;

import org.openqa.selenium.support.How;
import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails extends CommonFunctions {

    //OR
    @FindBy(id = "add_to_cart")
    WebElement add2Cartbtn;

    //Initialization
    public  ProductDetails(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public CheckOut add2Cart(){
        clickAfterElementAppears(add2Cartbtn);
        return new CheckOut();
    }
}


