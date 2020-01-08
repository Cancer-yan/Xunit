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
    String confPath=System.getProperty("user.dir")+"\\src\\main\\resources\\conf\\service\\weWork\\token.conf";
    private String corpid=null;
    private String corpsecret=null;
    private String token=null;
    @Test
    public String getToken() throws IOException {
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
