package selinium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import selinium.page.App;


import org.openqa.selenium.support.ui.WebDriverWait;
import selinium.page.App;
import selinium.page.Department;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class TestWeWork {
    public static App app ;
    @BeforeClass
    public static void beforeAll(){
        app=new App();
        app.login();
    }
    @Test
    public void addDepartment() throws InterruptedException {
        app.toContact().add("霍格沃兹2",3);
        //assertThat();
    }
    @Test
    public void selectDepartment() throws InterruptedException {
        app.toContact();
        Department department=new Department();
        department.selectDepartment(2,1);
    }
    @Test
    public void deleteDept() throws InterruptedException {
        app.toContact();
        Department department=new Department();
        department.deleteDepartment(1,2);
    }
}
