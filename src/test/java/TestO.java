import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestO extends BasePage{


    @BeforeSuite
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "src/browserDriver/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(invocationCount = 1)
    public void searchProduct() {
        String testSearchText = "монитор";

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(testSearchText);

        String expectedResult = driver.getTitle();
        String actualResult = "Мониторы - ROZETKA | Купить монитор для компьютера в Киеве: цена, отзывы, продажа";
        Assert.assertEquals(expectedResult, actualResult);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.ClickFirstProduct();
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}