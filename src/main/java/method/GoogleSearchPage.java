package method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    WebDriver driver;
    By searchField = By.xpath("//*[@title='Tìm kiếm']");
    By topicLink = By.xpath("//a[@href='http://www.nettruyen.com/']");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void googleInputKeyWord(String searchKeyWord) {
        driver.findElement(searchField).sendKeys(searchKeyWord);
    }

    public void googleStartSearch() {
        driver.findElement(searchField).submit();
    }

    public void click1stTopic() {
        driver.findElement(topicLink).click();
    }
}
