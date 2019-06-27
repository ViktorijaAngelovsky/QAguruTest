package qaGuruTest;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFunc {
    private WebDriver driver;

    public BaseFunc () {
        System.setProperty("webdriver.chrome.driver","/Users/Angelovsky/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        driver.get(url);
    }

    public void closeBrowser() {
        Assertions.assertNotNull(driver, "There is no opened window");
        driver.close();
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}
