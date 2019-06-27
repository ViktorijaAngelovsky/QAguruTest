package qaGuruTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import qaGuruTest.model.Reservation;

public class ReservationPage {
    private BaseFunc baseFunc;

    public ReservationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void reservation(Reservation res) {
        WebElement nameEnter = baseFunc.findElement(By.id("name"));
        nameEnter.sendKeys(res.getName());

        WebElement surnameEnter = baseFunc.findElement(By.id("surname"));
        surnameEnter.sendKeys(res.getSurname());

        WebElement discountEnter = baseFunc.findElement(By.id("discount"));
        discountEnter.sendKeys(res.getDiscount());

        WebElement adultsEnter = baseFunc.findElement(By.id("adults"));
        adultsEnter.sendKeys(res.getAdults());

        WebElement childrenEnter = baseFunc.findElement(By.id("children"));
        childrenEnter.sendKeys(res.getChildren());

        WebElement luggageEnter = baseFunc.findElement(By.id("bugs"));
        luggageEnter.sendKeys(res.getBugs());

        Select dropdown_flight = new Select(baseFunc.findElement(By.id("flight")));
        dropdown_flight.selectByValue(res.getFlight());

        baseFunc.findElement(By.id("book2")).click();

        baseFunc.findElement(By.xpath(".//div[contains(@class,'seat') and contains(text(),'" + res.getSeat() + "')]")).click();

        baseFunc.findElement(By.id("book3")).click();
    }
}
