package selinium.page;

import org.openqa.selenium.By;

public class Contact extends BasePage{
    public void add(String username){
        waitElement(By.id("username"),10);
        findElement(By.id("username")).sendKeys(username);

    }

}
