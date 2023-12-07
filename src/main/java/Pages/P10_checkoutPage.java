package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P10_checkoutPage extends pageBase{

    public P10_checkoutPage(WebDriver driver) {
        super(driver);
    }
     private final By checkBtn = By.cssSelector("div[class=\"cart-totals\"] ul li button");
     private final By emailInp = By.cssSelector("input[id=\"login-email\"]");
     private final By passInp = By.cssSelector("input[id=\"login-password\"]");
     private final By loginBtn = By.cssSelector("div[class=\"col-2\"] button");

     //billing info
     private final By  assertBillInfo = By.cssSelector("li[id=\"opc-billing\"] div h2");
     private final By add1Inp = By.id("billing:street1");
     private final By add2Inp = By.id("billing:street2");
     private final By cityInp = By.id("billing:city");
     private final By stateSel = By.id("billing:region_id");
     private final By zipInp = By.id("billing:postcode");
     private final By countySel = By.id("billing:country_id");
     private final By teteInp = By.id("billing:telephone");
     private final By continonBtn = By.cssSelector("div[id=\"billing-buttons-container\"]  button");

     //shipping method
    private final By shipBox = By.id("checkout-step-shipping_method");
    private final By shipBtn= By.cssSelector("div[id=\"shipping-method-buttons-container\"] button");

    //payment info
    private final By paymentBox = By.id("checkout-step-payment");
    private final By paymentCheck = By.cssSelector("input[id=\"p_method_checkmo\"]");
    private final By contionBtnPay =By.cssSelector("div[id=\"payment-buttons-container\"] button") ;

    //placeOrder
    private final By placeBox = By.id("checkout-step-review");
    private final By placeOrderBtn = By.cssSelector("div[id=\"review-buttons-container\"] button") ;

    //assert
    private final By assertPlaceOrder1 = By.cssSelector("div[class=\"col-main\"] h1") ;
    private final By assertPlaceOrder2 = By.cssSelector("div[class=\"col-main\"] h2") ;











    public void goToCheck()
    {
        clickEle(driver.findElement(checkBtn));
    }
    public void login(String email , String pass)
    {
        enterTxt(driver.findElement(emailInp),email);
        enterTxt(driver.findElement(passInp),pass );
        clickEle(driver.findElement(loginBtn));
    }

    public WebElement aseertBillInf()
    {
        return driver.findElement(assertBillInfo);
    }


    public void fillBillingInfo(String add1 , String add2 ,String city , String zip ,String tel)
    {

        driver.findElement(add1Inp).clear();
        enterTxt(driver.findElement(add1Inp),add1 );

        driver.findElement(add2Inp).clear();
        enterTxt(driver.findElement(add2Inp),add2 );

        driver.findElement(cityInp).clear();
        enterTxt(driver.findElement(cityInp),city );

        Select select = new Select(driver.findElement(stateSel));
        select.selectByValue("5");

        driver.findElement(zipInp).clear();
        enterTxt(driver.findElement(zipInp),zip );

        Select select2 = new Select(driver.findElement(countySel));
        select2.selectByValue("AS");

        driver.findElement(teteInp).clear();
        enterTxt(driver.findElement(teteInp),tel );

        clickEle(driver.findElement(continonBtn));
    }

    public WebElement assertShipBox()
    {
        return driver.findElement(shipBox);
    }

    public void shipMethodCont()
    {
        clickEle(driver.findElement(shipBtn));
    }



    public WebElement assertPayBox()
    {
        return driver.findElement(paymentBox);
    }

    public void paymentMeth()
    {
        clickEle(driver.findElement(paymentCheck));
    }

    public void paymentMethCont()
    {
        clickEle(driver.findElement(contionBtnPay));
    }


//place
    public WebElement assertPlaceBox()
    {
        return driver.findElement(placeBox);
    }

    public void placeOrd()
    {
        clickEle(driver.findElement(placeOrderBtn));
    }



    public WebElement assert1()
    {
        return driver.findElement(assertPlaceOrder1);
    }

    public WebElement assert2()
    {
        return driver.findElement(assertPlaceOrder2);
    }

}
