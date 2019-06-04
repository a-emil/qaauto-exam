package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//div[@id='top_nav']")
    private WebElement navigationMenu;

    @FindBy(xpath = "//div[@id='foot']//a[@aria-label = 'Page 2']")
    private WebElement secondPageLink;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getSearchResultNumber(){
        return searchResults.size();
    }

    public void goToSecondResultsPage(){
        secondPageLink.click();
    }

    public boolean isSearchResultsContainsSearhTerm() {
        for (WebElement searchResult : searchResults) {
            if(searchResult.getText().contains("Selenium")){
                return true;
            }
        }
        return false;
    }

    public boolean isPageLoaded() {
        return navigationMenu.isDisplayed();
    }
}
