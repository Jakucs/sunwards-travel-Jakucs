import com.codecool.Model.AccommodationBooking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccommodationBookingTest {
    @Test
    void AccommodationBookingLessThan7DaysTest(){
        AccommodationBooking accommodationBooking = new AccommodationBooking(6, 2, 45);
        assertEquals(540, accommodationBooking.getPrice());
    }

    @Test
    void AccommodationBookingMoreThan7DaysTest(){
        AccommodationBooking accommodationBooking = new AccommodationBooking(8, 2, 45);
        assertEquals(648, accommodationBooking.getPrice());
    }

    @Test
    void AccommodationBookingCancelLessThan14DaysTest(){
        AccommodationBooking accommodationBooking = new AccommodationBooking(6, 2, 45);
        assertEquals(135, accommodationBooking.cancel(6));
    }

    @Test
    void AccommodationBookingCancelMoreThan14DaysTest(){
        AccommodationBooking accommodationBooking = new AccommodationBooking(6, 2, 45);
        assertEquals(432, accommodationBooking.cancel(15));
    }

    @Test
    void AccommodationBookingCancelTest(){
        AccommodationBooking accommodationBooking = new AccommodationBooking(6, 2, 45);
        accommodationBooking.cancel(15);
        assertTrue(accommodationBooking.getIsCancelled());
    }

    @Test
    void AccommodationBookingIsNotCancelTest(){
        AccommodationBooking accommodationBooking = new AccommodationBooking(6, 2, 45);
        assertFalse(accommodationBooking.getIsCancelled());
    }

    @Test
    void AccommodationBookingIsNotValidArgumentsTest(){
        assertThrows(IllegalArgumentException.class, () -> new AccommodationBooking(-3, 2, 45));
    }

    @Test
    void AccommodationBookingIsNotValidArgumentsTest2(){
        assertThrows(IllegalArgumentException.class, () -> new AccommodationBooking(3, -2, 45));
    }
}
