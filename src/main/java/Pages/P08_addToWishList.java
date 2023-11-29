package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P08_addToWishList extends pageBase{
    public P08_addToWishList(WebDriver driver) {
        super(driver);
    }

     private final By wishListLink = By.linkText("Add to Wishlist");
     private final By assertWishListMsg = By.cssSelector("li[class=\"success-msg\"] ul li span");

     private final By btnEditWishList = By.cssSelector("td[class=\"wishlist-cell4 customer-wishlist-item-cart\"] a");

    private final By editInp = By.id("qty");
    private final By prodShop = By.cssSelector("div[class=\"product-shop\"]");
    private final By updateWishBtn = By.linkText("Update Wishlist");
    private final By assertAfterUpdate = By.cssSelector("li[class=\"success-msg\"] ul li span");

    private final By delBtn = By.cssSelector("a[title=\"Remove Item\"]");

    private final By assertEmpWishList = By.cssSelector("div[class=\"fieldset\"] p");





    public void goToWishList(){
        clickEle(driver.findElement(wishListLink));
    }

     public WebElement assertMsgWishList(){
        return driver.findElement(assertWishListMsg);
     }

     public void clickOnEditWishList()
     {
         clickEle(driver.findElement(btnEditWishList));
     }

     public WebElement waitProdShop()
     {
         return  driver.findElement(prodShop);
     }

     public void editQuenty(){
        driver.findElement(editInp).clear();
        driver.findElement(editInp).sendKeys("2");
        clickEle(driver.findElement(updateWishBtn));

     }

     public WebElement assertUpdateMsg()
     {
         return driver.findElement(assertAfterUpdate);
     }
     public void delWishList()
     {
         clickEle(driver.findElement(delBtn));
     }

   public WebElement assertEmptyWish(){
        return driver.findElement(assertEmpWishList) ;
   }


}
