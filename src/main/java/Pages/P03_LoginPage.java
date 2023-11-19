package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_LoginPage extends pageBase{

    public P03_LoginPage(WebDriver driver)
    {
        super(driver);
    }

    private final By emailInp = By.id("email");
    private final By passInp = By.id("pass");

    private final By logBTn = By.id("send2");

    private final By assertTitle = By.cssSelector("div[class=\"page-title\"] h1");

    private final By assertWelMsg = By.cssSelector("div[class=\"welcome-msg\"] p strong");
    private final By assertErrMsg = By.cssSelector("li[class=\"error-msg\"] span");
    private final By assertMsgBox = By.cssSelector("ul[class=\"messages\"]");



    public void loginSteps(String em , String pass)
    {
        enterTxt(driver.findElement(emailInp),em );
        enterTxt(driver.findElement(passInp), pass);
        clickEle(driver.findElement(logBTn));
    }

        public WebElement assertTit()
        {
           return driver.findElement(assertTitle);
        }

        public WebElement assertOnWelMsg()
        {
            return driver.findElement(assertWelMsg);
        }



    public WebElement assertOnErrMsg()
    {
        return driver.findElement(assertErrMsg);
    }
    public WebElement assertBoxMsg()
    {
        return driver.findElement(assertMsgBox);
    }


}
