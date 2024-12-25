package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.Utils;

public class AgriculturalForumPage extends BasePage {
    public AgriculturalForumPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void scrollToElement(By by) { // Cuộn đến phần tử
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void waitForPageToLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));
    }

    public By byBodyPost = By
            .xpath("//div[@style='transition: opacity 400ms, transform 400ms; transform: none; opacity: 1;'][1]");
    public By byBodyVideo = By.xpath("//div[@class='mt-3 video-sectn'][1]");
    public By byBodyArticle = By.xpath("//div[@class='row mb-2']");
    public By byBodyMarketPrice = By.xpath("//div[@class='col-md-9 col-sm-12 mkt-price']");
    public By boxLikeShareCmt = By.xpath("//div[@class=' d-flex justify-content-around align-items-center']");
    public By likebutton = By.xpath("//span[contains(text(),'Thích')]");
    public By likeCount = By.xpath("(//span[contains(@class,'txt') and contains(@class,'ml-1')])[1]");




    public By commentNew = By.xpath("//li[@class='false action-sort-new' and text()='Bình luận mới nhất']");

    public AgriculturalForumPage clickCommentsNew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentNew)).click();
        return this;
    }

    public AgriculturalForumPage clickLike() {
        // 1. Lấy số lượng like hiện tại trước khi click
        scrollToElement(likeCount);
        WebElement likeCountElement = driver.findElement(likeCount);
        int initialLikeCount = Integer.parseInt(likeCountElement.getText());
        // 2. Click vào nút like
        scrollToElement(likebutton);
        WebElement element = driver.findElement(likebutton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        // 3. Chờ để số lượt like thay đổi (chờ số lượt like mới)
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(likeCountElement, String.valueOf(initialLikeCount))));
        // 4. Kiểm tra số lượt like sau khi click
        int newLikeCount = Integer.parseInt(likeCountElement.getText());
        // 5. So sánh số lượt like
        if (newLikeCount == initialLikeCount + 1) {
            System.out.println("Like count increased by 1.");
        } else if (newLikeCount == initialLikeCount - 1) {
            System.out.println("Like count decreased by 1.");
        } else {
            System.out.println("Like count didn't change as expected.");
        }
        return this;
    }


    public By byComments = By.xpath(
            "(//span[contains(@class,'txt') and contains(@class,'fw-semibold') and contains(@class,'hover') and contains(@class,'ml-1') and text()='Bình luận'])[1]");

    public AgriculturalForumPage clickComments() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byComments)).click();
        return this;
    }

    public By byInputComment = By.xpath("//div[@id='editor']");

    public AgriculturalForumPage inputComment(String valueComment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byInputComment)).sendKeys(valueComment);
        return this;
    }

    public By bySubmitComent = By.xpath("//div[@class=' btn-send-trumb position-absolute']");

    public AgriculturalForumPage clickSubmitCommentPost() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySubmitComent)).click();
        return this;
    }

 
    public By byGivePoints = By.xpath("//span[@class='txt fw-semibold ml-1 hover color-585858' and text()='Tặng điểm']");
    public AgriculturalForumPage clickGivePoints() {
   wait.until(ExpectedConditions.visibilityOfElementLocated(byGivePoints)).click();
    return this;
   }



    public By byInputPoint = By.xpath("//input[@class='form-control' and @name='message' and contains(@placeholder, 'Nhập điểm muốn tặng Quang Doan')]");
    public AgriculturalForumPage inputsPoint( String valuePoint) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byInputPoint)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(byInputPoint)).sendKeys(valuePoint);
    return this;
    }

    public By byButtonGive = By.xpath("//button[@class='btn position-absolute  btn-sm btn-primary']");
    public AgriculturalForumPage clickGive() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byButtonGive)).click();
    return this;
    }




    public By byShare = By.xpath("//span[@class='txt fw-semibold ml-1 hover color-585858' and text()='Chia sẻ']");
    public AgriculturalForumPage clickShare() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byShare)).click();
    return this;
    }



    public By byShareOnSocial = By.xpath("//ul[@class='dropdown-menu dropdown-menu-end show']/li[2]");
    public AgriculturalForumPage clickShareOnSocial() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byShareOnSocial)).click();
    return this;
    }

    public By byInputValueSharePost = By.xpath("//textarea[@placeholder='Bạn có suy nghĩ gì?']");
    public AgriculturalForumPage inputInputValueSharePost(String valueShare) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byInputComment)).sendKeys(valueShare);
    return this;
    }

    public By bySubmitSharePost = By.xpath("//button[@class='w-100 btn-share-post btn btn-primary']");
    public AgriculturalForumPage clickSubmitSharePost() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(bySubmitSharePost)).click();
    return this;
    }
}
