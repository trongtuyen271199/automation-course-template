package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
 public void waitForPageToLoad() {
        // Đợi cho đến khi một phần tử nhất định xuất hiện trên trang
        // Hoặc có thể chờ trạng thái của document readyState là complete
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));
    }
    By byLoginBtn = By.xpath("//div[@class='login-with-two-nong user-name btn-login']//button[text()='Đăng nhập']");
    By byPhoneLoginText = By.xpath("//input[@name='phone'][1]");
    By bySubmitLogin = By.xpath("//button[@id='login'][1]");
    By byOtpCode = By.xpath("//input[@name='otp_code']");
    By byVerifyUserBtn = By.xpath("//button[@id='verify-user'][1]");
    public By byMessageErroFormatPhone = By
            .xpath("//div[contains(@class, 'login-errors') and contains(text(), 'Số điện thoại không phải là số')][1]");
    public By byMessageNullPhone = By
            .xpath("//div[contains(@class, 'login-errors') and contains(text(), 'Bạn chưa nhập số điện thoại')][1]");

    public LoginPage clickLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
        return this;
    }

    public LoginPage inputPhoneLogin(String phoneLogin) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPhoneLoginText)).sendKeys(phoneLogin);
        return this;
    }

    public LoginPage submitLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySubmitLogin)).click();
        return this;
    }

    public LoginPage inputOtpCode(String Otp) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOtpCode)).sendKeys(Otp);
        return this;
    }

    public LoginPage clickVerifyUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byVerifyUserBtn)).click();
        return this;
    }

}
