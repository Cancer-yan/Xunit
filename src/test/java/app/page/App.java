package app.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BaseTest{


    public static void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "4LTWCQORW8E6CA6P");
        desiredCapabilities.setCapability("app", "D:\\QMDownload\\Chrome\\xueqiu.apk");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", "true");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    public static SearchPage toSearch(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        App.driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        return new SearchPage();
    }

}
