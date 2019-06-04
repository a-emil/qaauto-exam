package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//img[@id='hplogo']")
    private WebElement googleLogo;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsPage searchRequest(){
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        return new SearchResultsPage(driver);
    }

    public boolean isPageLoaded() {
        return googleLogo.isDisplayed();
    }
}
