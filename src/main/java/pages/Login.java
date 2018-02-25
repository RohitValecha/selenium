package pages;


import utils.CommonFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends CommonFunctions {

    //Object Repository
    @FindBy(id="email")
    WebElement emailId;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;


    //Initializing Page Objects
    public Login(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public MyAccount Login(String username, String pass)
    {
        emailId.sendKeys(username);
        password.sendKeys(pass);
        submitLogin.click();
        return new MyAccount();
    }
}
