package TestCases;

import Data.ReadDataDrivenFromJson;
import Data.ReadDataDrivenLoginFromJson;
import Pages.P00_HomePage;
import Pages.P02_LogOutPage;
import Pages.P03_LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

public class TC02_LoginTest extends TestBase{
  P00_HomePage homePage ;
  SoftAssert softAssert = new SoftAssert();

  P03_LoginPage loginPage ;
  P02_LogOutPage logOutPage ;
    ReadDataDrivenLoginFromJson readDataDrivenLoginFromJson;

    @DataProvider
    public Object[] testDataforSucessduLogin() throws IOException, ParseException, org.json.simple.parser.ParseException {
        readDataDrivenLoginFromJson = new ReadDataDrivenLoginFromJson();
        return readDataDrivenLoginFromJson.testDataForSucessfulRegister();
    }

    @Test(dataProvider = "testDataforSucessduLogin")
    public void validLogin(String data) throws InterruptedException {
        //navigate to login
        homePage = new P00_HomePage(driver);
        homePage.clickOnAccount();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));
        homePage.clickONLoginLink();
        softAssert.assertTrue(driver.getCurrentUrl().contains("customer/account/login/"));


        //in login
        String users[] = data.split(",");

        loginPage = new P03_LoginPage(driver);
           loginPage.loginSteps(users[0],users[1]);
           Thread.sleep(3000);
           softAssert.assertEquals("MY DASHBOARD",loginPage.assertTit().getText());
//           softAssert.assertEquals("Hello, "+users[0]+" mahmoud "+users[1]+"!" ,loginPage.assertOnWelMsg().getText());


           //logOut
          logOutPage = new P02_LogOutPage(driver);
          logOutPage.clickMyAccount();
          logOutPage.clickLogOut();
          softAssert.assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/"));


        softAssert.assertAll();
    }

    @Test
    public void inValidLoginPass()
    {
        //navigate to login
        homePage = new P00_HomePage(driver);
        homePage.clickOnAccount();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));
        homePage.clickONLoginLink();
        softAssert.assertTrue(driver.getCurrentUrl().contains("customer/account/login/"));


        //in login
        loginPage = new P03_LoginPage(driver);
        loginPage.loginSteps("moaaz7@gmail.com","12345678");
        wait.until(ExpectedConditions.visibilityOf(loginPage.assertBoxMsg()));

        softAssert.assertTrue(loginPage.assertOnErrMsg().getText().contains("Invalid login or password."));

        driver.navigate().refresh();
        softAssert.assertAll();
    }









}
