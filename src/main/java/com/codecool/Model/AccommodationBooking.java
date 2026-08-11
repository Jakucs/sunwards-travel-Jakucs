package com.codecool.Model;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.math.BigDecimal;

public class AccommodationBooking  extends CancellableBooking{

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
    public BigDecimal getPrice() {
        if(nights<7){
            return UtilityMoney.makeDecimal(BASE_FEE*nights*rooms);
            //<---ezt kiszerrvezni külön osztályba, utility money osztályba pl. és ezt felhasználni. ez egy külön osztály felelőssége legyen.
            //mock+stream()
        } else {
            return UtilityMoney.makeDecimal(BASE_FEE*nights*rooms*PRICE_PERCENTAGE_FOR_LONG_STAY);
        }
    }
}