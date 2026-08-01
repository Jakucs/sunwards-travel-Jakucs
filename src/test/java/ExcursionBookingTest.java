import com.codecool.Model.ExcursionBooking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExcursionBookingTest {
    @Test
    void ExcursionBookingInValidArgumentTest(){
        assertThrows(IllegalArgumentException.class, () -> new ExcursionBooking(-5, 1, 85.50));
    }

    @Test
    void ExcursionBookingGetPriceTest(){
        ExcursionBooking excursionBooking = new ExcursionBooking(5, 2, 85.50);
        assertEquals(513, excursionBooking.getPrice());
    }

    @Test
    void ExcursionBookingCancelledLessThan14DaysTest(){
        ExcursionBooking excursionBooking = new ExcursionBooking(5, 2, 85.50);
        assertEquals(128.25, excursionBooking.cancel(5));
    }

    @Test
    void ExcursionBookingCancelledMoreThan14DaysTest(){
        ExcursionBooking excursionBooking = new ExcursionBooking(5, 2, 85.50);
        assertEquals(410.4, excursionBooking.cancel(15));
    }
}
