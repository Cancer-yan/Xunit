package selinium.page;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    public static WebDriver driver;
    @Test
    public void loginWithCooike(String url){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().addCookie(new Cookie("wwrtx.refid", "2723360625349312"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "DkAQaM1LD7cesTKVpe3yZTIzxgLAjUoHcKqKXELf6PZjWUInBW3V4gxWq0M-ngPI"));
        driver.navigate().refresh();
    }
    public WebElement findElement(By by){
        return driver.findElement(by);
    }

}
