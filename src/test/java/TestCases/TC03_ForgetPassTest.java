package TestCases;

import Pages.P00_HomePage;
import Pages.P04_ForgetPassPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC03_ForgetPassTest extends TestBase{
    P00_HomePage homePage ;
    SoftAssert softAssert = new SoftAssert();

    P04_ForgetPassPage forgetPassPage ;

    @Test
    public void ValidLoginForgetPass()
    {
        //navigate to login
        homePage = new P00_HomePage(driver);
        homePage.clickOnAccount();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));
        homePage.clickONLoginLink();
        softAssert.assertTrue(driver.getCurrentUrl().contains("customer/account/login/"));

        //navigate to forgetPass
        forgetPassPage = new P04_ForgetPassPage(driver);
        forgetPassPage.clickOnForgetPass();
        softAssert.assertTrue(driver.getCurrentUrl().contains("/forgotpassword/"));
        forgetPassPage.fillEmailForget("moaaz7@gmail.com");
        softAssert.assertTrue(forgetPassPage.assertOnMsg().getText().contains("If there is an account associated with moaaz7@gmail.com you will receive an email with a link to re"));

         driver.navigate().refresh();


    }



}
