package MyTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class AbstractStepDefs {

    private static final int WAIT_TIME = 10;

    static WebDriver driver;

    static Homepage homepage;

    static {
        /*
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        //options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
         */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        homepage = new Homepage(driver);

    }
}
