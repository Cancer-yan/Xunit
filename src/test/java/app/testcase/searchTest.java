package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class searchTest {
    @Test
    public void testSearch() throws MalformedURLException, InterruptedException {
        App app=new App();
        SearchPage searchPage=new SearchPage();
        app.setUp();
        app.toSearch();
        App.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage.search("alibaba");
    }
}
