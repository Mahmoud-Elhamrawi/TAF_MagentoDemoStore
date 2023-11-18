package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LogOutPage extends pageBase{
    public P02_LogOutPage(WebDriver driver) {
        super(driver);
    }

    private final By myAccountLink = By.xpath("//a[@href=\"http://live.techpanda.org/index.php/customer/account/\" and @data-target-element=\"#header-account\" ]");
    private final By logOutLink = By.xpath("//div[@id=\"header-account\" ]  //ul  //li[5] //a");


   public void clickMyAccount(){
       clickEle(driver.findElement(myAccountLink));
   }
    public void clickLogOut(){
        clickEle(driver.findElement(logOutLink));
    }

}
