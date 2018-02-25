package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import utils.CommonFunctions;

import java.util.concurrent.TimeUnit;

public class SearchPage extends CommonFunctions{

    //OR
    @FindBy(id = "search_query_top")
    WebElement search;

    @FindBy(xpath = "//button[@type='submit' and @name='submit_search']")
    WebElement searchBtn;

    public static WebElement sortBy= driver.findElement(By.id("selectProductSort"));
    //Initialization

    public SearchPage(WebDriver driver){
        this.driver=driver;

    }

    //Actions
    public ProductDetails navigateToProductfromSearchPage(String productName){
        clickProduct(productName);
        return new ProductDetails();
    }

    public SearchPage sortResults(){
        Select sel = new Select(sortBy);
        sel.getOptions();
        sel.selectByIndex(2);
//        clickOnOneElementAndAssertOnAnotherElement(sel.selectByIndex(2),sortBy);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        waitUntilStaleElementAppears(sortBy);
        sel.selectByValue("reference:asc");
        return this;
    }
}
