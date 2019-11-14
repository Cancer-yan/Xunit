package app.testcase;

import app.page.App;
import app.page.SearchPage;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class searchTest {
    @BeforeClass
    public static void beforAll() throws MalformedURLException {
        App.setUp();
    }

    @Test
    public void testSearch() throws MalformedURLException, InterruptedException {
        SearchPage searchPage=new SearchPage();
        App.toSearch();
        searchPage.search().getPrice();
    }
}
