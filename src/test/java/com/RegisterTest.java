package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class RegisterTest extends BasicTest {

    @Test(priority = 1)
    public void registerTestFailure() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailInputReg = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailInputReg.sendKeys("trongtuyen451@gmail.com");
        WebElement passInputReg = driver.findElement(By.xpath("//input[@id='reg_email']"));
        passInputReg.sendKeys("");

        WebElement RegBtn = driver.findElement(By.xpath("//button[contains(@class,'register')]"));
        RegBtn.click();
       // WebElement errorrMessageText = driver.findElement(By.xpath("//li[contains(@class,'logout')]"));
       WebElement errorrMessageText = driver.findElement(By.xpath("//strong[contains(text(), 'Lỗi:')]"));
       Assert.assertTrue(errorrMessageText.isDisplayed());

    }

}
