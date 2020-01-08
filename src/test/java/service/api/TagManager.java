package service.api;

import io.restassured.http.ContentType;
import service.BaseWeWork;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TagManager extends BaseWeWork {

    public void createTag(String tagname) throws IOException {
        HashMap<String, Object> data=new HashMap<>();
        data.put("tagname", tagname);

        given()
                .contentType(ContentType.JSON)
                .queryParam("access_token",BaseWeWork.getToken())
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
        .then()
                .log().all();

    }
}
