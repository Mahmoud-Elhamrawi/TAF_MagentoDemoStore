package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P09_addToCompare  extends pageBase{
    public P09_addToCompare(WebDriver driver)
    {
       super(driver);
    }

    private final By prof3rd = By.cssSelector("li[class=\"item last\"]:nth-child(3) ul a:nth-child(2)");
    private final By assertProdAddToCompare = By.cssSelector("li[class=\"success-msg\"] span");

    private final By prodst = By.cssSelector("li[class=\"item last\"]:nth-child(1) ul a:nth-child(2)");
    private final By compareBtn = By.cssSelector("div[class=\"block block-list block-compare\"] button");
    private final By closeWindowBtn = By.cssSelector("div[class=\"buttons-set\"] button");

    //clear
    private final By clearBtn = By.cssSelector("div[class=\"block-content\"] div[class=\"actions\"] a");

    private final By sucessMsg =By.cssSelector("li[class=\"success-msg\"]");
    private final By assertEmptComp = By.cssSelector("li[class=\"success-msg\"] span");





    public void clickOnPrd3rd()
    {
        clickEle(driver.findElement(prof3rd));
    }

    public WebElement assertTit()
    {
        return driver.findElement(assertProdAddToCompare);
    }

    public void clickOnPrd1st()
    {
        clickEle(driver.findElement(prodst));
    }
    public void clickOnCompareBtn(){
        clickEle(driver.findElement(compareBtn));
    }


    public void closeOtherWind()
    {
        clickEle(driver.findElement(closeWindowBtn));
    }

    public void clearList()
    {
        clickEle(driver.findElement(clearBtn));
    }


    public WebElement msgBox()
    {
        return driver.findElement(sucessMsg);
    }

    public WebElement assertEmpty()
    {
        return driver.findElement(assertEmptComp);
    }

}
