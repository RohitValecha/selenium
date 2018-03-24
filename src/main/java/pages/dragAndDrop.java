package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.io.*;

public class dragAndDrop extends CommonFunctions{

    public dragAndDrop(WebDriver driver){
        this.driver=driver;
    }

    String java_script="";
    String text;

    WebElement source = driver.findElement(By.id("one"));
    WebElement target = driver.findElement(By.id("bin"));

    public dragAndDrop dragAndDropObj() throws IOException {
        waitUntilElementAppears(source);
        BufferedReader input = new BufferedReader(new FileReader("C:\\Github\\backup\\selenium\\src\\main\\java\\utils\\drag_drop.js"));
        StringBuffer buffer = new StringBuffer();

        while ((text = input.readLine()) != null)
            buffer.append(text + " ");
        java_script = buffer.toString();

        input.close();

        String source = "one";
        String target = "bin";
        java_script = java_script+"$('#"+source+"').simulate( '#" +target+ "');" ;
        ((JavascriptExecutor)driver).executeScript(java_script);


        return this;


    }
}
