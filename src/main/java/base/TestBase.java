package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static String directory = System.getProperty("user.dir");
    public static int PAGE_LOAD_TIMEOUT = 20;
    public static int IMPLICIT_WAIT = 20;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(directory + "/src/main/java/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        String chromedriver_path = directory + "/src/main/java/config/chromedriver.exe";
        String geckodriver_path = directory + "/src/main/java/config/geckodriver.exe";
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromedriver_path);
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", geckodriver_path);
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

}
