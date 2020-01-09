package service.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import service.api.TagManager;

import java.io.IOException;

public class TestTagManager {
    static TagManager tagManager=new TagManager();
    @BeforeClass
    public static void beforeAll() throws IOException {
        tagManager.getListTag().path("");

    }


    @Test
    public void testTagManger() throws IOException {
        TagManager tagManager=new TagManager();
        tagManager.createTag("UI1");
    }


    @Test
    public void testTagUpdate() throws IOException {
        TagManager tagManager=new TagManager();
        tagManager.getListTag();
    }
    @Test
    public void list() throws IOException {

        tagManager.getListTag();
    }

}
