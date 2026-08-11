package com.codecool;

import com.codecool.Model.Booking;
import com.codecool.Model.Category;
import com.codecool.Model.Refundable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Itinerary {
    private String destination;
    private Category category;
    private int adults;
    private int children;
    private List<Booking> bookings = new ArrayList<>();

    public Itinerary(String destination, Category category, int adults, int children){
        if(category!=Category.BEACH&&category!=Category.CITY_BREAK&&category!=Category.MOUNTAIN){
            throw new IllegalArgumentException("Category must be BEACH, CITY_BREAK or MOUNTAIN");
        }else if (children < 0 || adults <0){
            throw new IllegalArgumentException("Persons can't be negative");
        }
        this.destination = destination;
        this.category = category;
        this.adults = adults;
        this.children = children;
    }

    public void addBooking(Booking booking){
        if(bookings.size() >= 10){
            throw new IllegalArgumentException("Booking can't be more than 10");
        }else{
            bookings.add(booking);
        }
    }

    public void allValidBooking(){
        BigDecimal allBookingPrice = BigDecimal.ZERO;
        for(Booking booking : bookings){
            allBookingPrice.add( booking.getPrice());
        }
    }

    public int getBookingsSize(){
        return bookings.size();
    }

    public BigDecimal getFullPrice(){
        BigDecimal fullPrice = BigDecimal.ZERO;
        for(Booking booking : bookings){
            if(booking instanceof Refundable refundable){
                if(!refundable.getIsCancelled()){
                    fullPrice = fullPrice.add(booking.getPrice());
                }
            }
        }
        if(bookings.isEmpty()){
            return BigDecimal.ZERO;
        }
        if((adults+children) >= 8){
            return fullPrice.multiply(BigDecimal.valueOf(0.95));
        }else{
            return fullPrice;
        }
    }

    public int getCancelledBookingsSize(){
        int allCancelledBookings = 0;
        for(Booking booking : bookings){
            if(booking instanceof Refundable refundable)
                if(refundable.getIsCancelled()){
                    allCancelledBookings+=1;
                }
        }
        return allCancelledBookings;
    }

    public Booking getBookingByID(int ID){
        for(Booking booking1 : bookings){
            if(booking1.getID() == ID){ //<-- it jön be a mock
                return booking1;
            }
        }
            throw new IllegalArgumentException("This booking doesn't exist");
    }

    public Category getCategory() {
        return category;
    }

    public String getDestination() {
        return destination;
    }
}
