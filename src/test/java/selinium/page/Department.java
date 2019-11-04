package selinium.page;

import org.openqa.selenium.By;

import java.util.List;

public class Department extends BasePage{
    public Department add(String name){
        waitElement(By.cssSelector(".member_colLeft_top_addBtn"),10);
        findElement(By.cssSelector(".member_colLeft_top_addBtn")).click();
        findElement(By.linkText("添加部门"));
        findElement(By.name("name")).sendKeys(name);
        findElement(By.linkText("选择所属部门")).click();



        return this;
    }
}
