package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.Test;

import java.net.MalformedURLException;

public class searchTest {
    @Test
    public void testSearch() throws MalformedURLException, InterruptedException {
        App app=new App();
        SearchPage searchPage=new SearchPage();
        app.setUp();
        Thread.sleep(8000);
        searchPage.search();
    }
}
