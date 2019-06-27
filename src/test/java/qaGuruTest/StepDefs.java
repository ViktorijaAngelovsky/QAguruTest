package qaGuruTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import qaGuruTest.model.Reservation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StepDefs {
    private Reservation reservation = new Reservation();
    private ReservationTest reservationTest = new ReservationTest();
    private Requester requester = new Requester();
    private List<Reservation> reservations;

    @Given("reservation data:")
    public void store_reservation(Map<String, String> params) {
        reservation.setName(params.get("name"));
        reservation.setSurname(params.get("surname"));
        reservation.setFrom(params.get("afrom"));
        reservation.setTo(params.get("ato"));
        reservation.setBugs(params.get("bugs"));
        reservation.setDiscount(params.get("discount"));
        reservation.setChildren(params.get("children"));
        reservation.setFlight(params.get("flight"));
        reservation.setAdults(params.get("adults"));
        reservation.setSeat(params.get("seat"));
    }

    @When("fill reservation form and close browser")
    public void fill_form() {
        reservationTest.reservationTest(reservation);
        reservationTest.closeBrowser();
    }

    @When("we are requesting data")
    public void get_reservation() throws IOException {
        reservations = requester.getReservation();
    }

    @Then("we check reservation presence and info")
    public void check_reservation() {
        Reservation lastReservation = reservations.get(reservations.size() - 1);
        Assertions.assertEquals(reservation.getName(), lastReservation.getName());
        Assertions.assertEquals(reservation.getSurname(), lastReservation.getSurname());
        Assertions.assertEquals(reservation.getFrom(), lastReservation.getFrom());
        Assertions.assertEquals(reservation.getTo(), lastReservation.getTo());
        Assertions.assertEquals(reservation.getBugs(), lastReservation.getBugs());
        Assertions.assertEquals(reservation.getDiscount(), lastReservation.getDiscount());
        Assertions.assertEquals(reservation.getChildren(), lastReservation.getChildren());
        Assertions.assertEquals(reservation.getFlight(), lastReservation.getFlight());
        Assertions.assertEquals(reservation.getAdults(), lastReservation.getAdults());
        Assertions.assertEquals(reservation.getSeat(), lastReservation.getSeat());
    }

}
