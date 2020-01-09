package service.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.BaseWeWork;

import java.io.IOException;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TagManager {

    public void createTag(String tagname){
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagname);

        given()
                .contentType(ContentType.JSON)
                .queryParam("access_token", BaseWeWork.getToken())
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
        .then().body("errmsg", equalTo("created"));

    }
    public void deleteTag(String tagid){

        given()
                .queryParam("access_token", BaseWeWork.getToken())
                .queryParam("tagid",tagid)
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/delete")
        .then().body("errmsg", equalTo("deleted"));

    }


    public void updateTag(String tagid, String tagname){
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagid", tagid);
        data.put("tagname", tagname);

        given()
                .contentType(ContentType.JSON)
                .queryParam("access_token", BaseWeWork.getToken())
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/update")
        .then().body("errmsg", equalTo("created"));

    }

    public Response getListTag(){

        Response response =given()
                .queryParam("access_token", BaseWeWork.getToken())
        .when()
                //.log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/list")
        .then().body("errmsg", equalTo("ok"))
                .extract().response();
        return response;
    }


}
