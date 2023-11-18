package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P00_HomePage extends pageBase{
    public P00_HomePage(WebDriver driver) {
        super(driver);
    }

   private final By AccountLink = By.xpath("//a[@href=\"http://live.techpanda.org/index.php/customer/account/\" and @data-target-element=\"#header-account\" ]");

    private final By myAccountLink =By.xpath("//div[@id=\"header-account\" ]  //ul  //li[1] //a");
    private final By registerLink = By.xpath("//div[@id=\"header-account\" ]  //ul  //li[5] //a");
    private final By headerAccount = By.id("header-account");
    public void clickOnAccount()
    {
        clickEle(driver.findElement(AccountLink));
    }

    public void clickOnRegisterLink()
    {
        clickEle(driver.findElement(registerLink));
    }


    public WebElement headerAccountVisiable()
    {
        return driver.findElement(headerAccount);
    }


    public void clickOnMyAccount()
    {
        clickEle(driver.findElement(myAccountLink));
    }


}
