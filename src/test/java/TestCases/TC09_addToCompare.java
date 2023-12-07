package TestCases;

import Pages.P06_CartPage;
import Pages.P09_addToCompare;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC09_addToCompare extends TestBase{

   P06_CartPage cartPage ;
   P09_addToCompare addToCompare;
   SoftAssert softAssert = new SoftAssert();


    @Test
    public void compareProds() {
        cartPage = new P06_CartPage(driver);
        cartPage.goToMobilePage();
        softAssert.assertTrue(driver.getCurrentUrl().contains("mobile.html"));
        softAssert.assertEquals(cartPage.titleAssert().getText() ,"MOBILE");

     //add third prod
        addToCompare = new P09_addToCompare(driver);
        addToCompare.clickOnPrd3rd();
        softAssert.assertEquals(addToCompare.assertTit().getText() ,"The product Samsung Galaxy has been added to comparison list.\n");
        //add  first prod
        addToCompare.clickOnPrd1st();
        softAssert.assertEquals(addToCompare.assertTit().getText() ,"The product Sony Xperia has been added to comparison list.\n");

        //switch to compare window
        String parent=driver.getWindowHandle();
        addToCompare.clickOnCompareBtn();

        driver.switchTo().newWindow(WindowType.WINDOW).get("http://live.techpanda.org/index.php/catalog/product_compare/index/");
        softAssert.assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/catalog/product_compare/index/"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,300)") ;

         addToCompare.closeOtherWind();

         driver.switchTo().window(parent);
        System.out.println(driver.getCurrentUrl());


        //clear compare prods
          addToCompare.clearList();
          Alert alert =   driver.switchTo().alert();
          alert.accept();

            WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(addToCompare.msgBox()));

            softAssert.assertEquals(addToCompare.assertEmpty().getText() , "The comparison list was cleared.");


    }


}
