package selinium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Department extends BasePage{
    Actions builder = new Actions(driver);
    //根据css选择器，查看点击树后节点中的个数
    private int countByCss(String className){
        List list=driver.findElements(By.className(className));
        int size=list.size();
        System.out.println("节点数为"+size);
        return size;
    }

    //添加部门
    public Department add(String deptName,int own) throws InterruptedException {
        waitElementAndClick(By.cssSelector(".member_colLeft_top_addBtn"),10);
        findElement(By.linkText("添加部门")).click();
        waitElementAndSendKey(By.name("name"),10, deptName);
        findElement(By.linkText("选择所属部门")).click();

        Thread.sleep(1000);

//        //根据传入的索引选择所属部门
//        if(own==0){
//            findElement(By.xpath("//form/div[2]/div/div/ul/li/a")).click();
//        }else if(own==1){
//            findElement(By.xpath("//div[2]/div/div/ul/li/ul/li"+"/a")).click();
//        }else{
//            findElement(By.xpath("//div[2]/div/div/ul/li/ul/li["+own+"]/a")).click();
//        }
//            findElement(By.linkText("确定")).click();
        //目前支持选择1级目录
        List list=driver.findElement(By.cssSelector(".jstree-2")).findElements(By.className("jstree-anchor"));
        System.out.println(list.size());
        WebElement elementA = driver.findElement(By.cssSelector(".jstree-2")).findElements(By.className("jstree-anchor")).get(own);
        builder.click(elementA).perform();

        Thread.sleep(3000);

        findElement(By.linkText("确定")).click();
        return this;
    }
    //选择左侧某个部门下的子部门，支持子节点选择
    public void selectDepartment(int father,int child) throws InterruptedException {
        waitElement(By.className("jstree-anchor"),20);
        int firstClick=countByCss("jstree-anchor");
        WebElement elementA = driver.findElements(By.className("jstree-anchor")).get(father);
        builder.doubleClick(elementA).perform();

        Thread.sleep(1000);

        int secondClick=countByCss("jstree-anchor");
        if(firstClick!=secondClick){
            driver.findElements(By.className("jstree-anchor")).get(father+child).click();
        }
    }
    //删除某个部门
    public void deleteDepartment(int father,int child) throws InterruptedException {
        //坑：需要先选择，然后才能根据css选择器选到后面那个按钮，否则是不可点击的状态
        selectDepartment(father,child);
        //findElement(By.xpath("//li/ul/li/ul/li/a/span")).click();
        driver.findElements(By.cssSelector(".jstree-contextmenu-hover")).get(father+child).click();
    }
}
