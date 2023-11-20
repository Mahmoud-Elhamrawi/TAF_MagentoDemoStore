package TestCases;

import Pages.P05_SearchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC04_SearchDirectTest extends TestBase{
    String searchVal ="iphone";
    SoftAssert softAssert = new SoftAssert();
    P05_SearchPage searchPage ;

    @Test
    public void searchDirectFromBtn()
    {
      searchPage = new P05_SearchPage(driver);
      searchPage.setTxtSearch(searchVal);
      searchPage.clickOnBtnSearch();

      softAssert.assertEquals("Search results for '"+searchVal+"'",searchPage.searchTitAssert().getText());



    }




}
