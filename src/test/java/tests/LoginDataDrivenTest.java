package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtil;

public class LoginDataDrivenTest extends BaseTest {

    @DataProvider(name = "loginExcelData")
    public Object[][] getData() {
        return ExcelUtil.getExcelData("testdata/LoginData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "loginExcelData")
    public void loginTest(String username, String password, String expected) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (expected.equals("success")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        } else {
            Assert.assertTrue(driver.getCurrentUrl().contains("error"));
        }
    }
}
