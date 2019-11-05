package selinium.page;

import org.openqa.selenium.By;
import java.util.List;

public class Department extends BasePage{
    public Department add(String name,int own){
        waitElement(By.cssSelector(".member_colLeft_top_addBtn"),10);
        findElement(By.cssSelector(".member_colLeft_top_addBtn")).click();
        findElement(By.linkText("添加部门")).click();
        waitElement(By.name("name"),10);
        findElement(By.name("name")).sendKeys(name);
        findElement(By.linkText("选择所属部门")).click();
        //根据传入的索引选择所属部门
        if(own==0){
            findElement(By.xpath("//form/div[2]/div/div/ul/li/a")).click();
        }else if(own==1){
            findElement(By.xpath("//div[2]/div/div/ul/li/ul/li"+"/a")).click();
        }else{
            findElement(By.xpath("//div[2]/div/div/ul/li/ul/li["+own+"]/a")).click();
        }
            findElement(By.linkText("确定")).click();
        return this;
    }
}
