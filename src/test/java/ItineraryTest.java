import com.codecool.BookingDesk;
import com.codecool.Model.AccommodationBooking;
import com.codecool.Model.Category;
import com.codecool.Model.Itinerary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItineraryTest {

    @Test
            void testItinerary(){
        AccommodationBooking accommodationBooking = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking2 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking3 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking4 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking5 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking6 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking7 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking8 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking9 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking10 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking11 = new AccommodationBooking(5, 2, 45);
        Itinerary itinerary = new Itinerary("Balkán", Category.BEACH, 5, 2);
        itinerary.addBooking(accommodationBooking);
        itinerary.addBooking(accommodationBooking2);
        itinerary.addBooking(accommodationBooking3);
        itinerary.addBooking(accommodationBooking4);
        itinerary.addBooking(accommodationBooking5);
        itinerary.addBooking(accommodationBooking6);
        itinerary.addBooking(accommodationBooking7);
        itinerary.addBooking(accommodationBooking8);
        itinerary.addBooking(accommodationBooking9);
        itinerary.addBooking(accommodationBooking10);
        assertThrows(IllegalArgumentException.class, ()-> itinerary.addBooking(accommodationBooking11));
    }

    @Test
    void getBooksSizeTest(){
        AccommodationBooking accommodationBooking = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking2 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking3 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking4 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking5 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking6 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking7 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking8 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking9 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking10 = new AccommodationBooking(5, 2, 45);
        AccommodationBooking accommodationBooking11 = new AccommodationBooking(5, 2, 45);
        Itinerary itinerary = new Itinerary("Balkán", Category.BEACH, 5, 2);
        itinerary.addBooking(accommodationBooking);
        itinerary.addBooking(accommodationBooking2);
        itinerary.addBooking(accommodationBooking3);
        itinerary.addBooking(accommodationBooking4);
        itinerary.addBooking(accommodationBooking5);
        itinerary.addBooking(accommodationBooking6);
        itinerary.addBooking(accommodationBooking7);
        itinerary.addBooking(accommodationBooking8);
        itinerary.addBooking(accommodationBooking9);
        itinerary.addBooking(accommodationBooking10);
        assertEquals(10, itinerary.getBookingsSize());
    }

    @Test
    void getBooksPriceTest() {
        AccommodationBooking accommodationBooking = new AccommodationBooking(6, 2, 45);
        AccommodationBooking accommodationBooking2 = new AccommodationBooking(8, 2, 45);
        Itinerary itinerary = new Itinerary("Balkán", Category.BEACH, 5, 2);
        itinerary.addBooking(accommodationBooking);
        itinerary.addBooking(accommodationBooking2);
        assertEquals(1188, itinerary.getFullPrice());
    }

    @Test
    void getCancelledBookingSizeTest() {
        AccommodationBooking accommodationBooking = new AccommodationBooking(6, 2, 45);
        AccommodationBooking accommodationBooking2 = new AccommodationBooking(8, 2, 45);
        Itinerary itinerary = new Itinerary("Balkán", Category.BEACH, 5, 2);
        itinerary.addBooking(accommodationBooking);
        itinerary.addBooking(accommodationBooking2);
        accommodationBooking2.cancel(15);
        assertEquals(1, itinerary.getCancelledBookingsSize());
    }

    @Test
    void getBookingByIDTest() {
        AccommodationBooking accommodationBooking = new AccommodationBooking(6, 2, 45);
        AccommodationBooking accommodationBooking2 = new AccommodationBooking(8, 2, 45);
        Itinerary itinerary = new Itinerary("Balkán", Category.BEACH, 5, 2);
        itinerary.addBooking(accommodationBooking);
        itinerary.addBooking(accommodationBooking2);
        accommodationBooking2.cancel(15);
        assertEquals(accommodationBooking, itinerary.getBookingByID(5001));
    }



}
