package service;

import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestWeWork {
    static String token=null;



    @BeforeClass
    public static void getToken(){

        token=given().param("corpid", "ww4830cbbae2d64840")
                .param("corpsecret", "valRV1Z46wHhR7Pt-DSAcwn14k5lYV0jqtJwn6aoryg")
        .when()
                .get("/cgi-bin/gettoken")
        .then()
                .log().all().body("errmsg",equalTo("ok"))
        .extract().body().path("access_token");
        System.out.println(token);
    }
    @Test
    public void createDepartment(){
        HashMap data=new HashMap();
        data.put("name","广州研发中心");
        data.put("parentid","2");
        given()
                .contentType(ContentType.JSON)
                .queryParam("access_token",token)
                .body(data)
        .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
        .then()
                .log().all().body("errcode",equalTo("0"));
    }
    @Test
    public void departmentList(){
        given()
                .queryParam("access_token",token)
                .queryParam("id",2)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then()
                .log().all();

    }

}
