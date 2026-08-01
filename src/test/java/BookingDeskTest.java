import com.codecool.Model.AccommodationBooking;
import com.codecool.Model.Category;
import com.codecool.Model.Itinerary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingDeskTest {
    @Test
    void getMostExpensiveTest() {
        BookingDeskTest bookingDesk = new BookingDeskTest();
        Itinerary itinerary1 = new Itinerary("Crete", Category.BEACH, 2, 0);
        Itinerary itinerary2 = new Itinerary("Paris", Category.CITY_BREAK, 2, 0);
        itinerary1.addBooking(new AccommodationBooking(7, 2, 100));
        itinerary2.addBooking(new AccommodationBooking(3, 1, 50));
        bookingDesk.addItinerary(itinerary1);
        bookingDesk.addItinerary(itinerary2);
        assertEquals(itinerary1, bookingDesk.getMostExpensive());
    }
}
