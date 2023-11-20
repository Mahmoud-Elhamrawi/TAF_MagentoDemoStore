package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P05_SearchPage extends pageBase {
    public P05_SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By searchInp =By.id("search");
    private final By searchBtn = By.cssSelector("button[class=\"button search-button\"]");
    private final By assertSearchTitle = By.cssSelector("div[class=\"page-title\"] h1");

    private final By searchList = By.id("search_autocomplete");
    private final By liOption= By.cssSelector("ul li[class=\"odd\"]") ;



          public void setTxtSearch(String txt)
          {
             enterTxt(driver.findElement(searchInp),txt );
          }
           public void clickOnBtnSearch()
          {
              clickEle(driver.findElement(searchBtn));
          }

          public WebElement searchTitAssert()
          {
              return driver.findElement(assertSearchTitle);
          }

    public WebElement searchListSuggest()
    {
        return driver.findElement(searchList);
    }




        public List<WebElement> listSearch()
          {
              return driver.findElements(liOption);
          }



}
