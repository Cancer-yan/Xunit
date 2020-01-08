package service.testcase;

import org.junit.Test;
import service.api.TagManager;

import java.io.IOException;

public class TestTagManager {
    @Test
    public void testTagManger() throws IOException {
        TagManager tagManager=new TagManager();
        tagManager.createTag("UI1");
    }
}
