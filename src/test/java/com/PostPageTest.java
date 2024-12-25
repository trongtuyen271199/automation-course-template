package com;

import org.bouncycastle.its.ITSValidityPeriod.Unit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.google.gson.annotations.Until;
import com.pages.AgriculturalForumPage;
import com.pages.HomePage;
import com.utils.BasicTest;
import com.utils.Utils;

public class PostPageTest extends BasicTest {
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

    public void scrollToElement(By by) { // Cuộn đến phần tử
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    String Otp = "123456";
    String valueSeach = "ai có kinh nghiệm cho mình hỏi với, sao cây này của mình bị vàng lá rồi";
    String urlPostResultSeach = "https://uat.hainong.vn/p/12603";

    @Test(dataProvider = "loginTestDataSuccess")
    public void ActionWithPost(String phoneLogin, boolean expectedOtpDisplay)
            throws Exception {
        String url = "https://uat.hainong.vn/";
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
        WebElement nameUser = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byNameUser));
        Assert.assertTrue(nameUser.isDisplayed());
        homePage.inputSeachBox(valueSeach);
        WebElement BoxResultSeach = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byBoxResultSeach));
        Assert.assertTrue(BoxResultSeach.isDisplayed());
        WebElement ResultSeach = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byResultSeach));
        Assert.assertTrue(ResultSeach.isDisplayed());
        homePage.clickResultSeach();
        Assert.assertEquals(driver.getCurrentUrl(), urlPostResultSeach);
        Utils.hardWait(5000);
        scrollToElement(By.xpath("(//span[contains(@class,'txt') and contains(@class,'ml-1')])[1]"));
        Utils.hardWait(5000);
        scrollToElement(By.xpath("//span[contains(text(),'Thích')]"));
        AgriculturalForumPage arAgriculturalForumPage = new AgriculturalForumPage(driver);
        arAgriculturalForumPage.clickLike();
        String valueComment = " bài post rất ý nghĩa 1";
        arAgriculturalForumPage.clickComments();
        arAgriculturalForumPage.inputComment(valueComment);
        arAgriculturalForumPage.clickSubmitCommentPost();
        Thread.sleep(5000);
        scrollToElement(By.xpath("//li[@class='false action-sort-new' and text()='Bình luận mới nhất']"));
        arAgriculturalForumPage.clickCommentsNew();
        String valuePoint = "1";
        arAgriculturalForumPage.clickGivePoints();
        Thread.sleep(5000);
        arAgriculturalForumPage.inputsPoint(valuePoint);
        arAgriculturalForumPage.clickGive();
        String valueShare = "Chia sẻ post";
        arAgriculturalForumPage.clickShare()
                               .clickShareOnSocial()
                               .inputInputValueSharePost(valueShare)
                               .clickSubmitSharePost();
        Thread.sleep(5000);
    }

}
// Muốn xem chậm lại sau acction nào thì thêm:  Utils.hardWait(5000);