import com.codecool.Model.FlightBooking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlightBookingTest {
    @Test
    void FlightBookingTest(){
        assertThrows(IllegalArgumentException.class, () ->new FlightBooking(-5, 2, 24.99));
    }

    @Test
    void FlightBookingGetPriceTest(){
        FlightBooking flightBooking = new FlightBooking(5, 2, 24.99);
        assertEquals(214.95, flightBooking.getPrice());
    }
}
