package qaGuruTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.web.client.RestTemplate;
import qaGuruTest.model.Reservation;

import java.io.IOException;
import java.util.List;

public class Requester {

    private final String DOMAIN = "http://qaguru.lv:8089/tickets";
    RestTemplate restTemplate = new RestTemplate();


    public List<Reservation> getReservation() throws IOException {
        String url = DOMAIN + "/getReservations.php";

        String stringToConvert = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        List<Reservation> reservations = objectMapper.readValue(stringToConvert, typeFactory.constructCollectionType(List.class, Reservation.class));

        return reservations;
    }

}
