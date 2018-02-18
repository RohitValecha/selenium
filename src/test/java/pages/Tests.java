package pages;


import org.BaseClass;
import org.Constants;
import org.testng.annotations.Test;

public class Tests extends BaseClass {


    @Test
    public void LoginTest() {
        openURL()
                .clickSignIn()
                .Login(Constants.Username,Constants.Password)
                .Logout();
        afterClass();

    }

    @Test
    public void navigateToProductDetails()  {
        openURL()
                .clickSignIn()
                .Login(Constants.Username,Constants.Password)
                .navigateToHome()
                .navigateToProductDetails();
        afterClass();
    }

    @Test
    public void add2Cart(){
        openURL()
                .clickSignIn()
                .Login(Constants.Username,Constants.Password)
                .navigateToHome()
                .navigateToProductDetails()
                .add2Cart();
        afterClass();
    }

    @Test
    public void createNewOrder(){
        openURL()
                .clickSignIn()
                .Login(Constants.Username,Constants.Password)
                .navigateToHome()
                .navigateToProductDetails()
                .add2Cart()
                .checkout()
                .checkOutSummary()
                .checkOutAddress()
                .checkOutShipping()
                .payment()
                .confirmOrder();
        afterClass();
    }
}




