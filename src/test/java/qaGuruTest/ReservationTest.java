package qaGuruTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import qaGuruTest.model.Reservation;

public class ReservationTest {
    private final String URL = "http://qaguru.lv:8089/tickets/";
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void reservationTest (Reservation reserv) {
        baseFunc.goToUrl(URL);
        MainPage mainPage = new MainPage(baseFunc);
        mainPage.destination();

        ReservationPage reservationPage = new ReservationPage(baseFunc);
        reservationPage.reservation(reserv);
    }

    @AfterEach
    public void closeBrowser(){
        baseFunc.closeBrowser();
    }

}
