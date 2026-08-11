import com.codecool.BookingDesk;
import com.codecool.Model.AccommodationBooking;
import com.codecool.Model.Category;
import com.codecool.Itinerary;
import com.codecool.Model.ExcursionBooking;
import com.codecool.Model.FlightBooking;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingDeskTest {
    @Test
    void getMostExpensiveTest() throws Exception {
        Itinerary itinerary1 = mock(Itinerary.class);
        when(itinerary1.getFullPrice()).thenReturn(BigDecimal.valueOf(1260.00));
        BookingDesk bookingDesk = new BookingDesk();
        //Itinerary itinerary1 = new Itinerary("Crete", Category.BEACH, 2, 0);
        Itinerary itinerary2 = new Itinerary("Paris", Category.CITY_BREAK, 2, 0);
        itinerary1.addBooking(new AccommodationBooking(7, 2, 100));
        itinerary2.addBooking(new AccommodationBooking(3, 1, 50));
        bookingDesk.addItinerary(itinerary1);
        bookingDesk.addItinerary(itinerary2);
        assertEquals(itinerary1, bookingDesk.getMostExpensive());
    }

    @Test
    void addItineraryTest(){
        Itinerary itinerary = new Itinerary("Olaszország", Category.CITY_BREAK, 2, 2);
        Itinerary itinerary2 = new Itinerary("Olaszország", Category.CITY_BREAK, 2, 2);
        BookingDesk bookingDesk = new BookingDesk();
        bookingDesk.addItinerary(itinerary);
        AccommodationBooking accommodationBooking = mock(AccommodationBooking.class);
        assertThrows(IllegalArgumentException.class, ()->bookingDesk.addItinerary(itinerary2));
    }

    @Test
    void deleteItineraryTest(){
        Itinerary itinerary = new Itinerary("Olaszország", Category.CITY_BREAK, 2, 2);
        BookingDesk bookingDesk = new BookingDesk();
        AccommodationBooking accommodationBooking = mock(AccommodationBooking.class);
        when(accommodationBooking.cancel(15)).thenReturn(BigDecimal.valueOf(120));
        when(accommodationBooking.getID()).thenReturn(1);
        itinerary.addBooking(accommodationBooking);
        bookingDesk.addItinerary(itinerary);

        assertEquals(BigDecimal.valueOf(120), bookingDesk.deleteItinerary("Olaszország", 1, 15));
    }

    @Test
    void getMostExpensiveTest2() throws Exception {
        BookingDesk bookingDesk = new BookingDesk();
        AccommodationBooking accommodationBooking = new AccommodationBooking(2, 3, 45);
        FlightBooking flightBooking = new FlightBooking(3, 3, 85);
        ExcursionBooking excursionBooking = new ExcursionBooking(4, 2, 25);
        AccommodationBooking accommodationBooking2 = new AccommodationBooking(2, 3, 45);
        FlightBooking flightBooking2 = new FlightBooking(3, 3, 85);
        ExcursionBooking excursionBooking2 = new ExcursionBooking(5, 2, 25);
        AccommodationBooking accommodationBooking3 = new AccommodationBooking(2, 3, 45);
        FlightBooking flightBooking3 = new FlightBooking(3, 3, 85);
        ExcursionBooking excursionBooking3 = new ExcursionBooking(10, 2, 25);
        Itinerary itinerary = new Itinerary("Olaszország", Category.BEACH, 2, 2);
        Itinerary itinerary2 = new Itinerary("Spanyolország", Category.CITY_BREAK, 3, 2);
        Itinerary itinerary3 = new Itinerary("Románia", Category.BEACH, 4, 2);
        itinerary.addBooking(accommodationBooking);
        itinerary.addBooking(flightBooking);
        itinerary.addBooking(excursionBooking);
        itinerary2.addBooking(accommodationBooking2);
        itinerary2.addBooking(flightBooking2);
        itinerary2.addBooking(excursionBooking2);
        itinerary3.addBooking(accommodationBooking3);
        itinerary3.addBooking(flightBooking3);
        itinerary3.addBooking(excursionBooking3);
        bookingDesk.addItinerary(itinerary);
        bookingDesk.addItinerary(itinerary2);
        bookingDesk.addItinerary(itinerary3);
        assertEquals(itinerary3, bookingDesk.getMostExpensive());
    }
}
