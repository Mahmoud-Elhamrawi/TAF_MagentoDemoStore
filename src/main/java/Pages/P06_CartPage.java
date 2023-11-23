package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P06_CartPage extends pageBase{
    public P06_CartPage(WebDriver driver)
    {
        super(driver);
    }

  private final By  mobileLink =  By.cssSelector("li[class=\"level0 nav-1 first\"] a");
  private final By assertTit = By.cssSelector("div[class=\"page-title category-title\"] h1");

  private  final By selProd = By.id("product-collection-image-1");
  private final By assertProdName = By.cssSelector("div[class=\"product-name\"] span");





  private final By addCartBtn = By.cssSelector("button[title=\"Add to Cart\"]");

  private final By msgSecuess = By.cssSelector("li[class=\"success-msg\"] ul span");

//update
    private final By updateInp = By.xpath("//input[@title=\"Qty\"]");
    private final By btnUpdate = By.xpath("//button[@type=\"submit\"  and text( )]");
    private final By assertCountCart = By.cssSelector("div[class=\"header-minicart\"] a :nth-child(3) ");


   private final By miniCart =By.cssSelector("class=\"header-minicart\"");



    //remove
    private final By removeBtn = By.cssSelector("td[class=\"a-center product-cart-remove last\"] a") ;
    private final  By assertRemove = By.cssSelector("div[class=\"page-title\"] h1");

        public void goToMobilePage()
        {
            clickEle(driver.findElement(mobileLink));
        }
        public WebElement titleAssert()
        {
            return driver.findElement(assertTit);
        }

        public void  prdoSele()
        {
            clickEle(driver.findElement(selProd));
        }

        public WebElement assertNameOfProd()
        {
            return driver.findElement(assertProdName);
        }





        public void cartBtn()
        {
            clickEle(driver.findElement(addCartBtn));
        }

        public WebElement assertTit()
        {
            return driver.findElement(msgSecuess);
        }


        //update
    public void updateQ( String q)
    {
        clickEle(driver.findElement(updateInp));
        driver.findElement(updateInp).clear();
        enterTxt(driver.findElement(updateInp),q );
    }

    public void clickOnUpdateBtn()
    {
        clickEle(driver.findElement(btnUpdate));
    }

     public WebElement countCart()
     {
         return driver.findElement(assertCountCart);
     }



     //remove
    public  void  removeIte(){
            clickEle(driver.findElement(removeBtn));
    }

  public WebElement assertRem(){
            return driver.findElement(assertRemove);
  }


}
