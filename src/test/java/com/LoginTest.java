package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {
    
    public boolean isLogoutDisplayed() {
        try {
            HomePage homePage= new HomePage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byLogoutBtn));
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    public void loginTestSuccess(String uname, String pw, boolean expectedLogoutDisplay) throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        LoginPage loginPage=new LoginPage(driver);     
        loginPage.enterEmail("uname")
        .enterPassword("pw")
        .enterLogin();
        Utils.hardWait(1000);
        boolean logoutBtnDisplayed = isLogoutDisplayed();
        Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);
    }
}
