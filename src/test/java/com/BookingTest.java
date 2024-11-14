package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class BookingTest extends BasicTest {

    @Test(priority = 1)
    public void registerTestFailure() throws Exception {
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
        //WebElement errorrMessageText = driver.findElement(By.xpath("//li[contains(@class,'logout')]"));
       // Assert.assertTrue(errorrMessageText.isDisplayed());

        WebElement seachBox = driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm...'][1]"));
        seachBox.sendKeys("Mercedes");
        WebElement optionFirts = driver.findElement(By.xpath("(//div[@class='fs-sremain fs-sremain-products']/a)[1]"));
        // Thread.sleep(5000);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Chờ cho đến khi phần tử có ID 'elementId' hiển thị
        // WebElement element =
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='fs-sremain
        // fs-sremain-products']/a)[1]")));
        optionFirts.click();
        WebElement selectOption = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']/option[@value='germany']"));
        selectOption.click();
        WebElement btnPlus = driver.findElement(By.xpath("//button[@class='plus']"));
        btnPlus.click();
        WebElement btnAdd = driver.findElement(By.xpath("//button[contains(@class,'single_add_to_cart_button')"));
        btnAdd.click();

        String urlCard = "https://bantheme.xyz/hathanhauto/gio-hang/";
        Assert.assertEquals(driver.getCurrentUrl(), urlCard);

        WebElement iconCard = driver.findElement(By.xpath("//div[@class='d-table-cell link-cart']//a/b[text()='2']"));
        Assert.assertTrue(iconCard.isDisplayed());
    }

}
