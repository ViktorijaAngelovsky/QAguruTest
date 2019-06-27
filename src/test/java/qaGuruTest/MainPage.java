package qaGuruTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    private BaseFunc baseFunc;
    private final By GOGOGO = By.xpath(".//span[contains(@class, 'gogogo')]");

    public MainPage (BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void destination () {
//        baseFunc.findElement(By.id("afrom")).click();
        Select dropdown_from = new Select(baseFunc.findElement(By.id("afrom")));
        dropdown_from.selectByIndex(2);

        Select dropdown_to = new Select(baseFunc.findElement(By.id("bfrom")));
        dropdown_to.selectByIndex(8);

        baseFunc.findElement(GOGOGO).click();


    }
}
