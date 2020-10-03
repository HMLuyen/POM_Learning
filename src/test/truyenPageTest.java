import base.TestBase;
import method.GoogleSearchPage;
import method.TruyenPage;
import org.junit.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class truyenPageTest extends TestBase {
    GoogleSearchPage googleSearchPage;
    TruyenPage truyenPage;

    @BeforeClass
    public void googleSetBaseURL() {
        initialization();
        googleSearchPage = new GoogleSearchPage(driver);
        truyenPage = new TruyenPage(driver);
    }

    @Test(priority = 0)
    public void googleInputKeyword() {
        googleSearchPage.googleInputKeyWord("net truyen");
    }

    @Test(priority = 1)
    public void googleSearching() {
        googleSearchPage.googleStartSearch();
    }

    @Test(priority = 2)
    public void googleVerifying() {
        String googleSearchTitle = driver.getTitle();
        Assert.assertEquals(googleSearchTitle, "net truyen - Tìm với Google");
    }

    @Test(priority = 3)
    public void googleClick1stTopic() {
        googleSearchPage.click1stTopic();
    }

    @Test(priority = 4)
    public void verify1stTopic() {
        String expectedTitle = "Đọc truyện tranh online - Truyện gì cũng có - NetTruyen";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority = 5)
    public void truyenClickLogin() {
        truyenPage.truyenClickLogin();
    }

    @Test(priority = 6)
    public void truyenInputEmail() {
        String email = "haminhluyen1992@gmail.com";
        truyenPage.truyenInputEmail(email);
    }

    @Test(priority = 7)
    public void truyenInputPass() {
        String pass = "12345678";
        truyenPage.truyenInputPass(pass);
    }

    @Test(priority = 8)
    public void truyenLogin() {
        truyenPage.truyenlogin();
    }

    @Test(priority = 9)
    public void verifyLogin() {
        Assert.assertTrue(truyenPage.truyenVerifylogin().contains("Cá nhân"));
    }

    @AfterClass
    public void end_test() {
        driver.close();
    }
}
