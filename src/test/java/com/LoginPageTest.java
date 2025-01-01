package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.HomePage;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginPageTest extends BasicTest {
    @DataProvider(name = "loginTestDataSuccess")
    public Object[][] testDataFeedSuccess() {
        Object[][] testdata = new Object[1][2];

        testdata[0][0] = "0339068627";
        testdata[0][1] = true;
        return testdata;
    }

    public boolean isOtpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='otp-code'][1]")));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    String Otp = "123456";

    @Test(dataProvider = "loginTestDataSuccess")
    public void loginTestSuccess(String phoneLogin, boolean expectedOtpDisplay)
            throws Exception {
        String url = "https://hainong.vn/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin()
                .inputPhoneLogin(phoneLogin)
                .submitLogin();
        boolean OtpPopupDisplayed = isOtpDisplayed();
        Assert.assertEquals(OtpPopupDisplayed, expectedOtpDisplay);
        loginPage.inputOtpCode(Otp)
                .clickVerifyUser();
        HomePage homePage = new HomePage(driver);
        Utils.hardWait(1000);
        WebElement nameUser = driver.findElement(homePage.byNameUser);
        Assert.assertTrue(nameUser.isDisplayed());
    }

    // @DataProvider(name = "loginTestDataFalse")
    // public Object[][] testDataFeedFalse() {
    //     Object[][] testdata = new Object[2][3];

    //     // Dữ liệu 1: Số điện thoại không hợp lệ (acbdfhjiur)
    //     testdata[0][0] = "acbdfhjiur"; // Số điện thoại không hợp lệ
    //     testdata[0][1] = true; // Kỳ vọng thông báo lỗi "Định dạng số điện thoại không hợp lệ" hiển thị
    //     testdata[0][2] = false; // Kỳ vọng thông báo lỗi "Số điện thoại không được để trống" không hiển thị

    //     // Dữ liệu 2: Số điện thoại trống
    //     testdata[1][0] = ""; // Số điện thoại rỗng
    //     testdata[1][1] = false; // Kỳ vọng thông báo lỗi "Định dạng số điện thoại không hợp lệ" không hiển thị
    //     testdata[1][2] = true; // Kỳ vọng thông báo lỗi "Số điện thoại không được để trống" hiển thị
    //     return testdata;
    // }

    // public boolean isMessageNullPhoneDisplayed() {
    //     try {
    //         LoginPage loginPage = new LoginPage(driver);
    //         // Kiểm tra thông báo lỗi khi số điện thoại trống
    //         wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.byMessageNullPhone));
    //         return true;
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }

    // public boolean isMessageErroFormatPhoneDisplayed() {
    //     try {
    //         LoginPage loginPage = new LoginPage(driver);
    //         // Kiểm tra thông báo lỗi khi số điện thoại có định dạng không hợp lệ
    //         wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.byMessageErroFormatPhone));
    //         return true;
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }

    // @Test(dataProvider = "loginTestDataFalse")
    // public void loginTestFalseNullPhone(String phoneLogin, boolean isMessageErroFormatPhoneDisplayedExpected,
    //         boolean isMessageNullPhoneDisplayedExpected) throws Exception {
    //     String url = "https://hainong.vn/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);
    //     LoginPage loginPage = new LoginPage(driver);
    //     loginPage.clickLogin()
    //             .inputPhoneLogin(phoneLogin)
    //             .submitLogin();

    //     // Kiểm tra các thông báo lỗi
    //     boolean isMessageErroFormatPhoneDisplayed = isMessageErroFormatPhoneDisplayed();
    //     boolean isMessageNullPhoneDisplayed = isMessageNullPhoneDisplayed();

    //     // Kiểm tra điều kiện khi số điện thoại rỗng
    //     if (phoneLogin.isEmpty()) {
    //         // Nếu số điện thoại trống, thông báo lỗi "Số điện thoại không được để trống"phải hiển thị
    //         Assert.assertEquals(isMessageNullPhoneDisplayed, isMessageNullPhoneDisplayedExpected);
    //     } else {
    //         // Nếu số điện thoại không trống và không hợp lệ, thông báo lỗi "Định dạng số điện thoại không hợp lệ" phải hiển thị
    //         Assert.assertEquals(isMessageErroFormatPhoneDisplayed, isMessageErroFormatPhoneDisplayedExpected);
    //     }
    // }

}
