package TestCases;

import Helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver ;
    @BeforeClass
    @Parameters({"browser"})
    public void serUp(@Optional("chrome") String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

        driver.get("");


    }



    @AfterClass
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterMethod()
    public void screenShotFailure(ITestResult result) throws IOException, InterruptedException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("fail...");
            System.out.println("taking screenshot.....");
            Helper.capturescreenshot(driver, result.getName());


        }
    }



}
