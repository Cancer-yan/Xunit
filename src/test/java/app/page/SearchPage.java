package app.page;


import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    private By inputBox=By.id("com.xueqiu.android:id/search_input_text");

    public SearchPage search(){
        App.driver.findElement(inputBox).sendKeys("alibaba");
        App.driver.findElement(By.id("com.xueqiu.android:id/name")).click();
        return this;
    }
    public Float getPrice(){
        MobileElement price=(MobileElement)App.driver.findElement(By.id("com.xueqiu.android:id/current_price"));
        return Float.valueOf(price.getText());
    }
}
