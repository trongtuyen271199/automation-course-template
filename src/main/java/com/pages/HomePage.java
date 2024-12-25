package com.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.Utils;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void waitForPageToLoad() {
        // Đợi cho đến khi một phần tử nhất định xuất hiện trên trang
        // Hoặc có thể chờ trạng thái của document readyState là complete
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));
    }

    public void scrollToElement(By by) { // Cuộn đến phần tử
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    // Element Box seach
    public By byBoxResultSeach = By.xpath("//div[@class='results-list scrollbar dropdown-menu dropdown-menu-end show ml-1 mt-2']");
    // Element Logo
    public By byLogo = By.xpath("(//a[@class='logo'])[1]");

    public HomePage clickLogo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLogo)).click();
        return this;
    }

    // Element Tìm Kiếm
    public By bySeachBox = By.xpath("//input[@placeholder='Tìm kiếm']");

    public HomePage inputSeachBox(String valueSeach) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySeachBox)).sendKeys(valueSeach);
        return this;
    }

    // Element Kết Quả tìm kiếm

    public By byResultSeach = By.xpath("//div[@class='search-result pointer fw-bolder']/a[@href='/p/12603']");

    public HomePage clickResultSeach() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byResultSeach)).click();
        return this;
    }

    // Element Icon Notication

    public By byIconNotication = By.xpath("//div[@class='notify-box']");

    public HomePage clickIconNotication() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byIconNotication)).click();
        return this;
    }

    // Element Name User
    public By byNameUser = By.xpath("(//span[@class='user-name' and text()='trọng tuyển'])[1]");

    public HomePage clickNameUser() {
        scrollToElement(byNameUser);
        Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byNameUser)).click();
        return this;
    }

    // Element Button Đăng Xuất

    public By byLogoutButton = By.xpath("(//li[@class='logout']/a/span[text()='Đăng xuất'])[1]");

    // Kiểm tra nút đăng xuất có xuất hiện không
    public boolean isLogoutButtonDisplayed() {
        try {
            WebElement buttonLogout = driver.findElement(byLogoutButton);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public HomePage clickLogout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLogoutButton)).click();
        return this;
    }

    // Element Diễn Đàn Nông Nghiệp Top
    public By byIconDienDanNongNghiep = By.xpath("//a[@href='/']//span[@class='icon-news02']");

    public HomePage clickIconĐienanNongNghiep() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byIconDienDanNongNghiep)).click();
        return this;
    }

    // Element Videos Top
    public By byIconVideo = By
            .xpath("//div[@class='d-flex justify-content-center position-relative']/span[@class='icon-triangle-line']");

    public HomePage clickIconVideo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byIconVideo)).click();
        return this;
    }

    // Element Article Top
    public By byIconArticle = By.xpath("//a[@href='/tin-tuc']");

    public HomePage clickIconArticle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byIconArticle)).click();
        return this;
    }

    // Element Giá Cả Thị Trường Top
    public By byIconMarketPrice = By.xpath("//span[@class='icon-price-menu']");

    public HomePage clickIconMarketPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byIconMarketPrice)).click();
        return this;
    }

    // Element Trang Cá Nhân
    public By byProfileLeftmenu = By.xpath("(//ul/li[1]//span[contains(text(), 'Trang cá nhân')])[2]");

    public HomePage clickViewMyProfile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byProfileLeftmenu)).click();
        return this;
    }

    // Element Sản Phẩm Của Tôi
    public By byMyProduct = By.xpath("(//ul/li[2]//span[contains(text(), 'Sản phẩm của tôi')])[2]");

    public HomePage clickViewMyProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byMyProduct)).click();
        return this;
    }
    // Element Đơn Hàng Của Tôi

    public By byMyInvoice = By.xpath("(//ul/li[3]//span[contains(text(), 'Đơn hàng của tôi')])[2]");

    public HomePage clickViewMyInvoice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byMyInvoice)).click();
        return this;
    }
    // Element Báo Cáo Tổng Quan

    public By byReport = By.xpath("//ul/li[4]//span[contains(text(), 'Báo cáo tổng quan')]");

    public HomePage clickViewReport() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byReport)).click();
        return this;
    }
    // Element Thiết Lập Vận Chuyển

    public By bySetupShiping = By.xpath("//ul/li[5]//span[contains(text(), 'Thiết lập vận chuyển')]");

    public HomePage clickSetupShiping() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySetupShiping)).click();
        return this;
    }

    // Element Đã Lưu
    public By bySaved = By.xpath("//ul/li[6]//span[contains(text(), 'Đã lưu')]");

    public HomePage clickViewSaved() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySaved)).click();
        return this;
    }

    // Element Bài Viết Của Tôi
    public By byMyPost = By.xpath("//ul/li[7]//span[contains(text(), 'Bài viết của tôi')]");

    public HomePage clickViewMyPost() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byMyPost)).click();
        return this;
    }
 
    // Element Thời Tiết

    public By byWeather = By.xpath("(//ul/li[a[@href='/modules/thoi-tiet']])[2]");

    public HomePage clickViewWeather() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byWeather)).click();
        return this;
    }

    // Element icon Plus Matket 2 Nông

    public By byIconPlusMarket = By.xpath("(//div[@class='plus-size'])[2]");

public By byLoiTat = By.xpath("//h4[@class='title-txt text-center' and text()='Lối tắt của bạn']");
    public HomePage clickViewIconPlusMarket() {
        scrollToElement(byIconPlusMarket);
        Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byIconPlusMarket)).click();
        return this;
    }

    // Element Option Chợ Nông Sản

    public By byOPtionChoNongSan = By.xpath("(//a[@href='/cho-2nong/nong-san']/div[text()='Chợ nông sản'])[2]");

    public HomePage clickViewChoNongSan() {
        scrollToElement(byOPtionChoNongSan);
        Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOPtionChoNongSan)).click();
        return this;
    }

    // Element Option Chợ Vật Tư Nông Nghiệp
    public By byOPtionChoVatTuNongNghiep = By
            .xpath("(//a[@href='/cho-2nong/vat-tu-nong-nghiep']/div[text()='Vật tư nông nghiệp'])[2]");

    public HomePage clickViewChoVatTuNongNghiep() {
        scrollToElement(byOPtionChoVatTuNongNghiep);
        Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOPtionChoVatTuNongNghiep)).click();
        return this;
    }

    // Element Chợ Sỉ Nông Nghiệp
    public By byOPtionChoSiNongNghiep = By
            .xpath("(//a[@href='/cho-2nong/si-nong-nghiep']/div[text()='Chợ sỉ nông nghiệp'])[2]");

    public HomePage clickViewSiNongNghiep() {
        scrollToElement(byOPtionChoSiNongNghiep);
        Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOPtionChoSiNongNghiep)).click();
        return this;
    }

    // Element Chợ Sản Xuất
    public By byOPtionChoSanXuat = By.xpath("(//a[@href='/cho-2nong/nha-san-xuat']/div[text()='Chợ sản xuất'])[2]");

    public HomePage clickViewChoSanXuat() {
        scrollToElement(byOPtionChoSanXuat);
        Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOPtionChoSanXuat)).click();
        return this;
    }

    // Element Quy Trình Kỹ Thuật

    public By byTechnicalProcess = By.xpath("(//span[text()='Quy trình kỹ thuật'])[2]");

    public HomePage clickViewTechnicalProcess() {
        scrollToElement(byTechnicalProcess);
        Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byTechnicalProcess)).click();
        return this;
    }

    // Element Quà Tặng

    public By byGift = By.xpath("(//a[@href='/shop-qua-tang']/span[@class='txt' and text()='Quà tặng'])[2]");

    public HomePage clickViewGift() {
        scrollToElement(byGift);
       Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byGift)).click();
        return this;
    }

    // Element Giọng Đọc

    public By byAudio = By.xpath("(//li/a[@href='/modules/giong-doc']/span[text()='Giọng đọc'])[2]");

    public HomePage clickViewAudio() {
        scrollToElement(byAudio);
       Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byAudio)).click();
        return this;
    }

    // Element Nhận Dạng Sâu Bệnh
    public By byPestIdentification = By.xpath("(//a[@href='/modules/nhan-dang-sau-benh']/span[text()='Nhận dạng sâu bệnh'])[2]");

    public HomePage clickViewPestIdentification() {
        scrollToElement(byPestIdentification);
    //    Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPestIdentification)).click();
        return this;
    }

    // Xpath của phần tử "Xem thêm"
    public By bySeeMoreMarketPrice = By.xpath("(//a[@href='/modules/gia-ca-thi-truong'])[2]");

    public HomePage clickViewSeeMoreMarketPrice() {
        scrollToElement(bySeeMoreMarketPrice);
     //   Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySeeMoreMarketPrice)).click();
        return this;
    }

    // Element Xem Dự Báo Đày Đủ
    public By bySeeWeatherForecast = By.xpath("//a[@class='btn-cmore more-btn-fll w-100 shadow text-center d-block']");

public By byboxwweather = By.xpath("//div[@class='box-bd weather']");
    public HomePage clickViewbySeeWeatherForecast() {
        // scrollToElement(bySeeMoreMarketPrice);
        Utils.hardWait(5000);
        scrollToElement(bySeeWeatherForecast);

       Utils.hardWait(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySeeWeatherForecast)).click();
        return this;
    }

}
