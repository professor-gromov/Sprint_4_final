import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.concurrent.TimeUnit;

public class CommonBaseTest {
    WebDriver driver;

/** Выбор браузера для прогона тестов*/
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver(options);

//        OperaOptions options = new OperaOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        WebDriverManager.operadriver().setup();
//        driver = new OperaDriver(options);

//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
/** Закрыть браузер*/
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }

}
