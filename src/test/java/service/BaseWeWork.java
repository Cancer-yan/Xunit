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
    private static String corpid=null;
    private static String corpsecret=null;
    private static String token=null;

    public static String getToken(){
        String confPath=System.getProperty("user.dir")+"\\src\\main\\resources\\conf\\service\\token.conf";
        //System.out.println(confPath);
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream(confPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
