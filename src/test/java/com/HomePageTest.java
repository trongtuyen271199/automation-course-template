package com;

import org.bouncycastle.its.ITSValidityPeriod.Unit;
import org.openqa.selenium.By;
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

public class HomePageTest extends BasicTest {
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
    String valueSeach = "ai có kinh nghiệm cho mình hỏi với, sao cây này của mình bị vàng lá rồi";
    String urlPostResultSeach = "https://uat.hainong.vn/p/12603";
    String urlVideo = "https://uat.hainong.vn/videos";
    String urlArticle = "https://uat.hainong.vn/tin-tuc";
    String urlMarketPrice = "https://uat.hainong.vn/modules/gia-ca-thi-truong";

    @Test(dataProvider = "loginTestDataSuccess")
    public void checkWorkfLow(String phoneLogin, boolean expectedOtpDisplay)
            throws Exception {
        String url = "https://uat.hainong.vn/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin()
                .inputPhoneLogin(phoneLogin)
                .submitLogin();
        Utils.hardWait(1000);
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
        homePage.waitForPageToLoad();
        WebElement ResultSeach = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byResultSeach));
        homePage.clickResultSeach();
        Assert.assertEquals(driver.getCurrentUrl(), urlPostResultSeach);
        homePage.clickLogo()
                .waitForPageToLoad();
        homePage.clickIconĐienanNongNghiep();
        AgriculturalForumPage agriculturalForumPage = new AgriculturalForumPage(driver);
        WebElement BodyPost = wait.until(ExpectedConditions.visibilityOfElementLocated(agriculturalForumPage.byBodyPost));
        Assert.assertTrue(BodyPost.isDisplayed());
        homePage.waitForPageToLoad();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        homePage.clickIconVideo();
        WebElement BodyVideo = wait.until(ExpectedConditions.visibilityOfElementLocated(agriculturalForumPage.byBodyVideo));
        Assert.assertTrue(BodyVideo.isDisplayed());
        homePage.waitForPageToLoad();
        Assert.assertEquals(driver.getCurrentUrl(), urlVideo);
        homePage.clickIconArticle();
        WebElement BodyArticle = wait.until(ExpectedConditions.visibilityOfElementLocated(agriculturalForumPage.byBodyArticle));
        Assert.assertTrue(BodyArticle.isDisplayed());
        homePage.waitForPageToLoad();
        Assert.assertEquals(driver.getCurrentUrl(), urlArticle);
        homePage.clickIconMarketPrice();
        WebElement BodyMarketPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(agriculturalForumPage.byBodyMarketPrice));
        Assert.assertTrue(BodyMarketPrice.isDisplayed());
        homePage.waitForPageToLoad();
        Assert.assertEquals(driver.getCurrentUrl(), urlMarketPrice);
        homePage.waitForPageToLoad();
        homePage.clickViewMyProfile();
        Utils.hardWait(3000);
        homePage.clickViewMyProduct();
                Utils.hardWait(3000);
                homePage .clickViewMyInvoice();
                Utils.hardWait(3000);
        homePage.clickViewReport();
        Utils.hardWait(3000);
        homePage  .clickSetupShiping();
                Utils.hardWait(3000);
                homePage .clickViewSaved();
                Utils.hardWait(3000);
                homePage .clickViewMyPost();
                Utils.hardWait(3000);
                homePage .clickViewWeather();
                Utils.hardWait(3000);
                homePage  .clickLogo();
                Utils.hardWait(3000);
                homePage.clickViewIconPlusMarket();
                Utils.hardWait(3000);
                homePage   .clickViewChoNongSan();
                Utils.hardWait(3000);
                homePage .clickViewIconPlusMarket();
                Utils.hardWait(3000);
                homePage .clickViewChoVatTuNongNghiep();
                Utils.hardWait(3000);
                homePage  .clickViewSiNongNghiep();
                Utils.hardWait(3000);
                homePage .clickViewChoSanXuat();
                Utils.hardWait(3000);
                homePage   .clickViewIconPlusMarket();
                Utils.hardWait(3000);
                homePage .clickViewTechnicalProcess();
                Utils.hardWait(3000);
                homePage .clickViewGift()  ;
                Utils.hardWait(3000); 
                homePage  .clickViewAudio() ;
                Utils.hardWait(3000);    
                homePage.clickIconĐienanNongNghiep();
                Utils.hardWait(3000);    
                homePage  .clickViewPestIdentification();
                Utils.hardWait(3000);
                homePage .clickViewSeeMoreMarketPrice();
                Utils.hardWait(3000);
               // homePage.clickIconĐienanNongNghiep();
               // Utils.hardWait(3000);
                Thread.sleep(10000);
                homePage.clickViewbySeeWeatherForecast();
                Utils.hardWait(3000);
                homePage    .clickNameUser();
                Utils.hardWait(3000);
                homePage .clickLogout();
                Utils.hardWait(3000);
        Thread.sleep(10000);

    }

}
