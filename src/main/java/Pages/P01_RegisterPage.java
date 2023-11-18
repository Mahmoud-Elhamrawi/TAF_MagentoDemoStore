package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_RegisterPage  extends pageBase{
    public P01_RegisterPage(WebDriver driver) {
        super(driver);
    }
    private final By assertOnPAgeTitle = By.cssSelector("div[class=\"page-title\"] h1");

    public WebElement assertTitle()
    {
        return driver.findElement(assertOnPAgeTitle);
    }

    private final By fNameInp =By.id("firstname");
    private final By mNameInp = By.id("middlename");
    private final By lNameInp = By.id("lastname");
    private final By emailAddInp = By.id("email_address");
    private final By passInp = By.id("password");
    private final By confirmPassInp = By.id("confirmation");
    private final By registerBtn = By.cssSelector("div[class=\"buttons-set\"] button");

    private final By assertSucMsg = By.cssSelector("li[class=\"success-msg\"] ul li span");
    private final By assertWelMsg = By.cssSelector("div[class=\"welcome-msg\"] strong");
    private final By assertMsgNavBar = By.cssSelector("div[class=\"header-language-background\"] p");

    private final By assertErrorMsg =By.cssSelector("ul[class=\"messages\"] li ul li span");



    public void registerStepsAllFeaild(String FN , String MN , String LN , String email , String pass , String Cpass)
    {
        enterTxt(driver.findElement(fNameInp),FN );
        enterTxt(driver.findElement(mNameInp),MN );
        enterTxt(driver.findElement(lNameInp),LN );
        enterTxt(driver.findElement(emailAddInp),email );
        enterTxt(driver.findElement(passInp),pass );
        enterTxt(driver.findElement(confirmPassInp),Cpass );

        clickEle(driver.findElement(registerBtn));
    }

    public void registerStepsMandatoryFeaild(String FN , String LN , String email , String pass , String Cpass)
    {
        enterTxt(driver.findElement(fNameInp),FN );
        enterTxt(driver.findElement(lNameInp),LN );
        enterTxt(driver.findElement(emailAddInp),email );
        enterTxt(driver.findElement(passInp),pass );
        enterTxt(driver.findElement(confirmPassInp),Cpass );

        clickEle(driver.findElement(registerBtn));
    }


    public WebElement assertMsg()
    {
        return driver.findElement(assertSucMsg);
    }
    public WebElement assertWel()
    {
        return driver.findElement(assertWelMsg);
    }


    public WebElement assertMsgOnNav()
    {
        return driver.findElement(assertMsgNavBar);
    }

    public WebElement assertErrorMSG()
    {
        return driver.findElement(assertErrorMsg);
    }


}
