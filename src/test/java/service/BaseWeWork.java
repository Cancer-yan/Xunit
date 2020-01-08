package service;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author qiang.yan
 * @version 1.0
 * @date 2020/1/8 12:47 Create
 */

public class BaseWeWork {
    static String confPath=System.getProperty("user.dir")+"\\src\\resources\\conf\\service\\token.conf";
    private static String corpid=null;
    private static String corpsecret=null;
    private static String token=null;

    public static String getToken() throws IOException {
        System.out.println(confPath);
        Properties properties=new Properties();
        properties.load(new FileInputStream(confPath));
        corpid=properties.getProperty("corpid");
        corpsecret=properties.getProperty("corpsecret");

        return token=
        given()
                .queryParam("corpid",corpid)
                .queryParam("corpsecret",corpsecret)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then()
                .body("errmsg",equalTo("ok"))
        .extract().body().path("access_token");


    }


}
