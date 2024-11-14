package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class LoginTest extends BasicTest {

    @Test(priority = 1, enabled = false)
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("trongtuyen451@gmail.com");
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys("Admin@123456");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        WebElement exitText = driver.findElement(By.xpath("//li[contains(@class,'logout')]"));
        Assert.assertTrue(exitText.isDisplayed());

    }

    @Test(priority = 2)
    public void loginTestFailure() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("trongtuyen451@gmail.com");
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys("Admin@123456");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        WebElement errorrMessageText = driver.findElement(By.xpath("//li[contains(@class,'logout')]"));
        Assert.assertTrue(errorrMessageText.isDisplayed());

    }

}
