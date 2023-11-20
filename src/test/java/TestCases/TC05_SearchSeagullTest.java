package TestCases;

import Pages.P05_SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC05_SearchSeagullTest extends TestBase{

    String textVal ="sony";
    SoftAssert softAssert = new SoftAssert();
    P05_SearchPage searchPage ;
    @Test
    public void searchFromList() throws InterruptedException {

        searchPage = new P05_SearchPage(driver);
        searchPage.setTxtSearch(textVal);
        Thread.sleep(2000);
        searchPage.listSearch().get(5).click();
        softAssert.assertEquals("SEARCH RESULTS FOR 'SONY 1111@@@@'",searchPage.searchTitAssert().getText());








        softAssert.assertAll();

    }



}
