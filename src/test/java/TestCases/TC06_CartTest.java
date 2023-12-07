package TestCases;

import Pages.P06_CartPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TC06_CartTest extends TestBase{
    P06_CartPage cartPage ;
    SoftAssert softAssert = new SoftAssert();
    String count = "5";

    @Test
    public void addToCart(){
        cartPage = new P06_CartPage(driver);
        cartPage.goToMobilePage();

        softAssert.assertTrue(driver.getCurrentUrl().contains("mobile.html"));
        softAssert.assertEquals(cartPage.titleAssert().getText() ,"MOBILE");

    //add to cart
        cartPage.prdoSele();
        softAssert.assertEquals(cartPage.assertNameOfProd().getText() , "SONY XPERIA");
        cartPage.cartBtn();
        softAssert.assertEquals(cartPage.assertTit().getText() , "Sony Xperia was added to your shopping cart.");
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = "addToCart")
    public void modifyCart()
    {
        cartPage = new P06_CartPage(driver);

         cartPage.updateQ(count);
        cartPage.clickOnUpdateBtn();

        softAssert.assertEquals(cartPage.countCart().getText() ,count );
        softAssert.assertAll();
    }


    @Test(dependsOnMethods ="modifyCart" )
    public void removeCart(){
        cartPage = new P06_CartPage(driver);
        cartPage.removeIte();
        softAssert.assertEquals(cartPage.assertRem().getText() , "SHOPPING CART IS EMPTY");
        softAssert.assertEquals(cartPage.countCart().getText() ,"0" );

    }



}
