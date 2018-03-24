package Tests;

import base.BaseClass;
import config.ExcelReader;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Tests extends ExcelReader {

    private static final Logger log= Logger.getLogger(Tests.class);

    @Test(priority = 1)
    public void loginTest(){
        Login();
    }

    @Test(priority = 2,dataProvider = "dataProvider")
    public void navigateTOProduct(HashMap<String,String> map){
        Login()
                .navigateToHome()
                  .navigateToProduct(map.get("ProductName"));
    }

    @Test(priority = 3)
    public void createOrder(){
        log.info("Stating OrderCreation");
        Login()
                .navigateToHome()
                .navigateToProduct("Faded Short Sleeve T-shirts")
                .add2Cart()
                .checkout()
                .checkOutSummary()
                .checkOutAddress()
                .checkOutShipping()
                .payment()
                .confirmOrder();
        log.info("OrderCreation completed");
    }

    @Test(priority = 4)
    public void searchAndCreateOrder(){
        Login()
                .navigateToHome()
                .searchProduct("Blouse")
                .navigateToProductfromSearchPage("Blouse")
                .add2Cart()
                .checkout()
                .checkOutSummary()
                .checkOutAddress()
                .checkOutShipping()
                .payment()
                .confirmOrder();
    }

    @Test(priority = 5,dataProvider = "dataProvider")
    public void sortSearchResults(Map<String ,String> map){
        Login()
                .navigateToHome()
                .searchProduct(map.get("ProductName"))
                .sortResults();
    }
}
