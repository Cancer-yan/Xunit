package selinium.page;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;
    @Test
    public void loginWithCookie(String url){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().addCookie(new Cookie("wwrtx.refid", "2723360625349312"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "DkAQaM1LD7cesTKVpe3yZZhsbvyD4qVYMGUJzYtTF71N3H7CN7SmrFzA_Cde4_fA"));
        driver.navigate().refresh();
    }
    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    public void waitElement(By by,int timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

}
