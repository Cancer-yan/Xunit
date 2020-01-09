package service.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.BaseWeWork;

import java.io.IOException;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TagManager {

    public Response createTag(String tagname){
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagname);
        Response response=
        given()
                .contentType(ContentType.JSON)
                .queryParam("access_token", BaseWeWork.getToken())
                .body(data)
        .when()
                //.log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
        .then().body("errmsg", equalTo("created"))
        .extract().response();
        return response;
    }
    public void deleteTag(int tagid){

        given()
                .queryParam("access_token", BaseWeWork.getToken())
                .queryParam("tagid",tagid)
        .when()
                //.log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/delete")
        .then().body("errmsg", equalTo("deleted"));

    }


    public void updateTag(int tagid, String tagname){
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagid", tagid);
        data.put("tagname", tagname);

        given()
                .contentType(ContentType.JSON)
                .queryParam("access_token", BaseWeWork.getToken())
                .body(data)
        .when()
                //.log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/update")
        .then()
                //.log().all()
                .body("errmsg", equalTo("updated"));

    }

    public Response getListTag(){

        Response response =given()
                .queryParam("access_token", BaseWeWork.getToken())
        .when()
                //.log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/list")
        .then()
                .log().all()
                .body("errmsg", equalTo("ok"))
                .extract().response();
        return response;
    }


}
