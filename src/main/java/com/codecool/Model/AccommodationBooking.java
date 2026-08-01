package com.codecool.Model;

import java.time.LocalDate;

public class AccommodationBooking  extends Booking implements Refundable{

    private double BASE_FEE;
    private static double PRICE_PERCENTAGE_FOR_LONG_STAY = 0.90;
    private int nights;
    private int rooms;

    private boolean isCancelled;

    public AccommodationBooking(int nights, int rooms, double BASE_FEE) {
        super();
        if(nights<=0 || rooms<=0 || BASE_FEE <0){
            throw new IllegalArgumentException("Nights and Rooms and BASE_FEE can't be 0 or negative.");
        }
        this.nights = nights;
        this.rooms = rooms;
        this.BASE_FEE = BASE_FEE;
    }

    @Override
    public double getPrice() {
        if(nights<7){
            return (double) Math.round(BASE_FEE * nights * rooms * 100) / 100;
        } else {
            return (double) Math.round((BASE_FEE * nights * rooms) * PRICE_PERCENTAGE_FOR_LONG_STAY * 100) / 100;
        }
    }


    @Override
    public double cancel(int daysRemaining) {
        if(daysRemaining<0){
            throw new IllegalArgumentException("Days remaining can't be negative");
        } else if (isCancelled){
            throw new IllegalArgumentException("A reservation can't be canceled twice.");
        }
        if(daysRemaining>14){
            this.isCancelled=true;
            return (double) Math.round(getPrice() * 0.80 * 100) / 100;
        } else {
            this.isCancelled=true;
            return (double) Math.round(getPrice() * 0.25 * 100) / 100;
        }
    }

    @Override
    public boolean getIsCancelled() {
        return isCancelled;
    }
}
