import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utility.ApplicationProperties;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseTest {

    public WebDriver driver = null;
    ApplicationProperties applicationProperties = ApplicationProperties.INSTANCE;

    @BeforeTest
    public void setUp(){

        System.setProperty("webdriver.chrome.logfile", "TestLog.txt");
        WebDriverManager.chromedriver().arch64().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get(applicationProperties.getUrl());
        driver.manage().window().maximize();
        sleeps(1000);
        assertThat(driver.getTitle(), is(applicationProperties.getTitle()));
    }

    @AfterTest
    public void teatDown() {
        driver.quit();
    }

    public void sleeps(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
