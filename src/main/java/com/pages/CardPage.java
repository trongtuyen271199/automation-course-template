package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardPage extends BasePage {
    public CardPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By byOptionOne = By.xpath("//a[text()='Bơm nước xe ']");
    By byXuatSu = By.xpath("//select[@id='pa_xuat-xu']/option[@value='germany']");
    By byBtnPlus = By.xpath("//button[@class='plus']");
    By byAdd = By.xpath("//button[contains(@class,'single_add_to_cart_button')]");
    By byIconCard2 = By.xpath("//div[@class='d-table-cell link-cart']//a/b[text()='2']");
    By byProductRemove = By.xpath("//td[@class='product-remove']");

    public CardPage clickOptionOne() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOptionOne)).click();
        return this;
    }

    public CardPage clickXuatXu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byXuatSu)).click();
        return this;
    }

    public CardPage clickIconPlus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byBtnPlus)).click();
        return this;
    }

    public CardPage clickAdd() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byAdd)).click();
        return this;
    }

    // Element Card Page
    public CardPage removeProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byProductRemove)).click();
        return this;
    }
}
