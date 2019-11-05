package selinium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Department extends BasePage{
    Actions builder = new Actions(driver);
    //根据css选择器，查看点击树后节点中的个数
    private int countByCss(String selector){
        List list=driver.findElements(By.className(selector));
        int size=list.size();
        System.out.println("节点数为"+size);
        return size;
    }

    //添加部门
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
    //选择某个某个部门下的子部门
    public void selectDepartment(int father,int child){
        waitElement(By.className("jstree-anchor"),20);
        int firstClick=countByCss("jstree-anchor");
        WebElement elementA = driver.findElements(By.className("jstree-anchor")).get(father);
        builder.doubleClick(elementA).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int secondClick=countByCss("jstree-anchor");
        if(firstClick!=secondClick){
            driver.findElements(By.className("jstree-anchor")).get(father+child).click();
        }
    }

}
