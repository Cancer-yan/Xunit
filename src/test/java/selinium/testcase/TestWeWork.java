package selinium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import selinium.page.App;

public class TestWeWork {
    public static App app ;
    @BeforeClass
    public static void beforeAll(){
        app=new App();
    }
    @Test
    public void addDepartment(){
        app.login();
        app.toContact().add();
    }
}
