package tests;

import base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JSONUtil;

public class LoginJSONTest extends BaseTest {

    @Test
    public void loginUsingJSON() {

        JSONObject data = JSONUtil.getJSON("testdata/login.json");

        String username = data.get("username").toString();
        String password = data.get("password").toString();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login failed using JSON data");
    }
}
