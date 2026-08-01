package com.codecool.Model;

import java.time.LocalDate;

public abstract class Booking {
    private static int counter = 5000;
    private int bookingID;

    public Booking(){
        this.bookingID = ++counter;
    }

    public int getID(){
        return bookingID;
    }

    public abstract double getPrice();


}
