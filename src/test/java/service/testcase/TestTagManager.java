package service.testcase;

import io.restassured.response.ResponseBody;
import org.junit.BeforeClass;
import org.junit.Test;
import service.api.TagManager;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;

public class TestTagManager {
    static TagManager tagManager=new TagManager();
    @BeforeClass
    public static void beforeAll() throws IOException {
        ArrayList<Integer> arr=new ArrayList<>();
        arr=tagManager.getListTag().path("taglist.tagid");
        arr.forEach(id-> tagManager.deleteTag(id));
    }

    @Test
    public void list() {
        tagManager.getListTag();
    }

    @Test
    public void testCreateTag(){
        String tagname="UI";
        TagManager tagManager=new TagManager();
        tagManager.createTag(tagname);
        tagManager.getListTag().then().body("taglist.findAll{t->t.tagname=='"+tagname+"'}", hasSize(1));
    }

    @Test
    public void testDeleteTag(){
        String tagname="TEST";
        TagManager tagManager=new TagManager();
        int tagid=tagManager.createTag(tagname).body().path("tagid");
        tagManager.deleteTag(tagid);
    }

    @Test
    public void updateTag(){
        String tagname="QA";
        int tagid=tagManager.createTag(tagname).body().path("tagid");
        tagManager.updateTag(tagid,"QA_test");
        tagManager.getListTag().then().body("taglist.findAll{t->t.tagname=='QA_test'}", hasSize(1));
    }

}
