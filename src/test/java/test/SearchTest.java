package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultsPage;

public class SearchTest extends BaseTest {

    @Test
    public void searchResultsTest(){
        Assert.assertTrue(searchPage.isPageLoaded(), "Page is not loaded");
        SearchResultsPage searchResultsPage = searchPage.searchRequest();
        Assert.assertEquals(searchResultsPage.getSearchResultNumber(), 9, "Wrong number of search results");
        Assert.assertTrue(searchResultsPage.isSearchResultsContainsSearhTerm(),"All search results contain search term 'Selenium'");

        searchResultsPage.goToSecondResultsPage();

        Assert.assertEquals(searchResultsPage.getSearchResultNumber(), 10, "Wrong number of search results");
        Assert.assertTrue(searchResultsPage.isSearchResultsContainsSearhTerm(),"All search results contain search term 'Selenium'");
    }
}
