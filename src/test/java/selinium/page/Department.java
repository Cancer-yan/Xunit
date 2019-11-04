package selinium.page;

import org.openqa.selenium.By;

public class Department extends BasePage{
    public Department add(){
        findElement(By.cssSelector(".member_colLeft_top_addBtn")).click();
        return this;
    }
}
