import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{

    private By resultsGrid = By.cssSelector("div.layout_with_sidebar");
    private By productItem = By.xpath("//a[@href='https://hard.rozetka.com.ua/samsung_lc27g54tqwixci/p250703981/']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(resultsGrid).isDisplayed();
    }

    public ProductPage ClickFirstProduct() {
        driver.findElement(productItem).click();
        return new ProductPage(driver);
    }
}