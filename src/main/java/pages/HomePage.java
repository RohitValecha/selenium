package pages;

import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends CommonFunctions {
    //OR
    @FindBy(className = "login")
    WebElement signInbtn;

    @FindBy(id = "search_query_top")
    WebElement search;

    @FindBy(xpath = "//button[@type='submit' and @name='submit_search']")
    WebElement searchBtn;

    //Initialization
    public  HomePage(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public Login clickSignIn(){
        clickAfterElementAppears(signInbtn);
        return new Login();
    }


    public ProductDetails navigateToProduct(String productName){

        clickProduct(productName);
        return new ProductDetails();
    }

    public SearchPage searchProduct(String searchString){
        search.sendKeys(searchString);
        clickAfterElementAppears(searchBtn);
//        waitUntilElementAppears(getProduct(productName));
        return new SearchPage(driver);
    }
}