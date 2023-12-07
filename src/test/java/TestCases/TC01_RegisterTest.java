package TestCases;

import Data.ReadDataDrivenFromJson;
import Pages.P00_HomePage;
import Pages.P01_RegisterPage;
import Pages.P02_LogOutPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

public class TC01_RegisterTest extends TestBase{

    P00_HomePage homePage ;
    P01_RegisterPage registerPage;
    P02_LogOutPage logOutPage;
    SoftAssert softAssert = new SoftAssert();




    @Test
    public void validRegister()
    {

        homePage = new P00_HomePage(driver);
        registerPage = new P01_RegisterPage(driver);
        //navigate to register page
        homePage.clickOnAccount();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));

        homePage.clickOnRegisterLink();

        softAssert.assertTrue(driver.getCurrentUrl().contains("customer/account/create"));


        //in register page
        softAssert.assertEquals("CREATE AN ACCOUNT",registerPage.assertTitle().getText());

        registerPage.registerStepsAllFeaild("moaaz","mahmoud","elhamrawi","moaaz7@gmail.com","1234567","1234567");

        softAssert.assertTrue(registerPage.assertMsg().getText().contains("Thank you for registering"));
        softAssert.assertEquals("Hello, moaaz mahmoud elhamrawi!" , registerPage.assertWel().getText());
        softAssert.assertTrue(registerPage.assertMsgOnNav().getText().contains("WELCOME, MOAAZ "));


        //logOut
        logOutPage = new P02_LogOutPage(driver);
        logOutPage.clickMyAccount();
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));
        logOutPage.clickLogOut();
        softAssert.assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/"));


        softAssert.assertAll();

    }


    ReadDataDrivenFromJson readDataDrivenFromJson;

    @DataProvider
    public Object[] testDataforSucessduRegister() throws IOException, ParseException, org.json.simple.parser.ParseException {
        readDataDrivenFromJson = new ReadDataDrivenFromJson();
        return readDataDrivenFromJson.testDataForSucessfulRegister();
    }


    @Test(dataProvider = "testDataforSucessduRegister")
    public void validRegisterWithMandtoryFeaild(String data) throws InterruptedException {

        String users[] = data.split(",");


        homePage = new P00_HomePage(driver);
        registerPage = new P01_RegisterPage(driver);
        //navigate to register page
        homePage.clickOnAccount();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));

        homePage.clickOnRegisterLink();

        softAssert.assertTrue(driver.getCurrentUrl().contains("customer/account/create"));


        //in register page
        softAssert.assertEquals("CREATE AN ACCOUNT",registerPage.assertTitle().getText());

        registerPage.registerStepsMandatoryFeaild(users[0],users[1],users[2],users[3]);
        Thread.sleep(3000);
        softAssert.assertTrue(registerPage.assertMsg().getText().contains("Thank you for registering"));
        softAssert.assertEquals(registerPage.assertWel().getText() ,"Hello, "+users[0]+" "+users[1]+"!");

        //logOut
        logOutPage = new P02_LogOutPage(driver);
        logOutPage.clickMyAccount();
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));
        logOutPage.clickLogOut();
        softAssert.assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/"));

        softAssert.assertAll();

    }





    @Test
    public void inValidRegisterWithExitEmail()
    {

        homePage = new P00_HomePage(driver);
        registerPage = new P01_RegisterPage(driver);
        //navigate to register page
        homePage.clickOnAccount();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));

        homePage.clickOnRegisterLink();

        softAssert.assertTrue(driver.getCurrentUrl().contains("customer/account/create"));


        //in register page
        softAssert.assertEquals("CREATE AN ACCOUNT",registerPage.assertTitle().getText());

        registerPage.registerStepsMandatoryFeaild("moaaz","elhamrawi","moaaz6@gmail.com","1234567");
         softAssert.assertTrue(registerPage.assertErrorMSG().getText().contains("There is already an account with this email address"));

        //MyAccount
        homePage.clickOnAccount();
        wait.until(ExpectedConditions.visibilityOf(homePage.headerAccountVisiable()));
         homePage.clickOnMyAccount();
        softAssert.assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/"));

        softAssert.assertAll();

    }


}
