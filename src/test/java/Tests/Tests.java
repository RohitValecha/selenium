package Tests;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class Tests extends BaseClass {

    HomePage home;

    @Test(priority = 1)
    public void loginTest(){
        Login();
    }

    @Test(priority = 2)
    public void navigateTOProduct(){
        Login()
                .navigateToHome()
                .navigateToProduct("Faded Short Sleeve T-shirts");
    }

    @Test(priority = 3)
    public void createOrder(){
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

    @Test(priority = 5)
    public void sortSearchResults(){
        Login()
                .navigateToHome()
                .searchProduct("short")
                .sortResults();

    }
}
