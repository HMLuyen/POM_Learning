package method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TruyenPage {
    WebDriver driver;
    By searchField = By.xpath("//input[@placeholder='Tìm truyện...']");
    By startSearch = By.xpath("//input[@type='submit']");
    By truyen1stLink = By.xpath("//*[@id='ctl00_divCenter']/div[2]/div/div/div/div[1]/figure/figcaption/h3/a");
    By viewmoreButton = By.xpath("//*[@id='nt_listchapter']/nav/a");
    By firstChapter = By.xpath("//a[text()='Chapter 1']");

    By login = By.xpath("//a[text()='Đăng nhập']");
    By emailFill = By.xpath("//input[@id='ctl00_mainContent_login1_LoginCtrl_UserName']");
    By passFill = By.xpath("//input[@id='ctl00_mainContent_login1_LoginCtrl_Password']");
    By loginButton = By.xpath("//input[@id='ctl00_mainContent_login1_LoginCtrl_Login']");
    By loginProfile = By.xpath("//*[@id='aspnetForm']/header/div/div/ul/li/a");

    public TruyenPage(WebDriver driver) {
        this.driver = driver;
    }

    public void truyenInputKeyWord(String searchKeyWord) {
        driver.findElement(searchField).sendKeys(searchKeyWord);
    }

    public void truyenStartSearch() {
        driver.findElement(startSearch).click();
    }

    public void truyenClick1stLink() throws InterruptedException {
        driver.findElement(truyen1stLink).click();
        Thread.sleep(500);
    }

    public void truyenClickMoreview() throws InterruptedException {
        driver.findElement(viewmoreButton).click();
        Thread.sleep(500);
    }

    public void truyenClickFirstChapter() {
        driver.findElement(firstChapter).click();
    }

    public void truyenClickLogin() {
        driver.findElement(login).click();
    }

    public void truyenInputEmail(String email) {
        driver.findElement(emailFill).sendKeys(email);
    }

    public void truyenInputPass(String pass) {
        driver.findElement(passFill).sendKeys(pass);
    }

    public void truyenlogin() {
        driver.findElement(loginButton).click();
    }

    public String truyenVerifylogin() {
        return driver.findElement(loginProfile).getText();
    }
}
