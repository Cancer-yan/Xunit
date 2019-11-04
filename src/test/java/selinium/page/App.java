package selinium.page;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App extends BasePage{

    public App login(){
        String url = "https://work.weixin.qq.com/wework_admin/loginpage_wx";
        loginWithCookie(url);
        return this;
    }
    public Department toContact(){
        driver.findElement(By.linkText("通讯录")).click();
        return new Department();
    }
}
