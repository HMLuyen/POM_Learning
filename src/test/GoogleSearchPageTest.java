import method.TruyenPage;
import org.junit.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import base.TestBase;
import method.GoogleSearchPage;

public class GoogleSearchPageTest extends TestBase {
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
    public void truyenFillSearch() {
        String searchKey = "one punch";
        truyenPage.truyenInputKeyWord(searchKey);
    }

    @Test(priority = 6)
    public void truyenStartSearch() {
        truyenPage.truyenStartSearch();
    }

    @Test(priority = 7)
    public void truyenClick1stLink() throws InterruptedException {
        truyenPage.truyenClick1stLink();
    }

    @Test(priority = 8)
    public void truyenClickMoreview() throws InterruptedException {
        truyenPage.truyenClickMoreview();
    }

    @Test(priority = 9)
    public void truyenClick1stChapter() {
        truyenPage.truyenClickFirstChapter();
    }

    @Test(priority = 10)
    public void verifyChapter() {
        String expectedTitle = "Anh Hùng OnePunch Chap 1 Next Chap 2 - NetTruyen";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterClass
    public void end_test() {
        driver.close();
    }
}
