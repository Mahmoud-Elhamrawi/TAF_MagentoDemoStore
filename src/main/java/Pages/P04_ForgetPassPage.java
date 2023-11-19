package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P04_ForgetPassPage extends pageBase{
    public P04_ForgetPassPage(WebDriver driver) {
        super(driver);
    }

    private final By forgetPassLink = By.cssSelector("ul[class=\"form-list\"] li>a");
    private final By emilInp = By.id("email_address");
    private final By submitBtn = By.cssSelector("div[class=\"buttons-set\"] button[class=\"button\"]");
    private final By assertSucMsg = By.cssSelector("li[class=\"success-msg\"] ul li  span");


    public void clickOnForgetPass()
    {
        clickEle(driver.findElement(forgetPassLink));
    }
    public void fillEmailForget(String em)
    {
        enterTxt(driver.findElement(emilInp), em);
        clickEle(driver.findElement(submitBtn));
    }

    public WebElement assertOnMsg()
    {
        return driver.findElement(assertSucMsg);
    }

}
