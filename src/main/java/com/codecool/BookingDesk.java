package com.codecool;

import com.codecool.Model.Booking;
import com.codecool.Model.Category;
import com.codecool.Model.Refundable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookingDesk {
    List<Itinerary> itineraries = new ArrayList<>();

    public BookingDesk(){

    }

    public void addItinerary(Itinerary itinerary){
        for(Itinerary itinerary1 : itineraries){
            if(itinerary1.getDestination().equals(itinerary.getDestination())){
                throw new IllegalArgumentException("This Itinerary exist");
            }
        }
            itineraries.add(itinerary);
    }

    public BigDecimal getItinerariesPrice(){
        BigDecimal fullItinerariesPrice = BigDecimal.ZERO;
        for(Itinerary itinerary : itineraries){
            fullItinerariesPrice.add(itinerary.getFullPrice());
        }
        return fullItinerariesPrice;
    }

    public List<Itinerary> getItineraryByCategory(Category category){
        List<Itinerary> itineraries1 = new ArrayList<>();
        for(Itinerary itinerary : itineraries){
            if(itinerary.getCategory()==category){
                itineraries1.add(itinerary);
            }
        }
        return itineraries1;
    }

    public Itinerary getMostExpensive() throws Exception {
        if(itineraries.isEmpty()){
            throw new Exception("List is empty");
        }
        Itinerary mostExpensiveItinerary = itineraries.getFirst();
        for(Itinerary itinerary : itineraries){
            if(mostExpensiveItinerary.getFullPrice().compareTo(itinerary.getFullPrice()) < 0){
                mostExpensiveItinerary = itinerary;
            }
        }
            return mostExpensiveItinerary;
    }

    public BigDecimal deleteItinerary(String destination, int ID, int daysRemaining){
        for(Itinerary itinerary : itineraries){
            if(itinerary.getDestination().equals(destination)){
                Booking booking = itinerary.getBookingByID(ID);
                if(booking instanceof Refundable refundable){
                    return refundable.cancel(daysRemaining);
                }else{
                    throw new IllegalArgumentException("Booking must be refundable.");
                }
            }
        }
        throw new IllegalArgumentException("Destination does not exist.");
    }
}
