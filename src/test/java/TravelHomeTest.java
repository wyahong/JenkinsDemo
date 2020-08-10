import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : yahong
 * @Version : V1.0
 * @ClassName : TravelHomeTest
 * @Description : Jenkins演练
 * @date : 2020/8/10 17:12
 */
public class TravelHomeTest {

    private static RemoteWebDriver driver;

    @BeforeAll
    static void beforeAll(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://travel.qunar.com/p-oi710603-gugong");
    }

    @Test
    void case_note(){

        driver.findElement(By.cssSelector("#more_cmt_href")).click();

        String name = driver.findElement(By.linkText("马一轮先生")).getText();

        assertEquals("马一轮先生", name);

    }

    @AfterAll
    static void quit(){
        driver.quit();
    }
}
