package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P07_addReview extends pageBase{
    public P07_addReview(WebDriver driver) {
        super(driver);
    }

    private final By addReviewLink = By.linkText("Add Your Review");
    private final By qualityRadio = By.cssSelector("input[type=\"radio\"]");
    private final By reviewInp  = By.id("review_field");
    private final By reviewSum = By.id("summary_field");
    private final By reviewNick = By.id("nickname_field");
    private final By submitReviewBtn = By.cssSelector("div[class=\"buttons-set\"] button[type=\"submit\"]");
    private final By assertReview = By.cssSelector("li[class=\"success-msg\"] ul li span");








    public void goToAddReviewPage()
    {
        clickEle(driver.findElement(addReviewLink));
    }

    public List<WebElement>  radioBtn()
    {
        return driver.findElements(qualityRadio);
    }

    public void fillingReviewForm(String inp1 , String inp2 ,String inp3)
    {
        enterTxt(driver.findElement(reviewInp),inp1);
        enterTxt(driver.findElement(reviewSum),inp2 );
        enterTxt(driver.findElement(reviewNick),inp3 );
        clickEle(driver.findElement(submitReviewBtn));
    }
    public WebElement assertOnAddReview()
    {
        return driver.findElement(assertReview);
    }




}
