package com.codecool.Model;

import java.math.BigDecimal;

public class FlightBooking  extends Booking{

    private double BASE_FEE;
    public static final double BAG_FEE = 45.00;
    private int seats;
    private int bags;

    public FlightBooking(int seats, int bags, double BASE_FEE) {
        super();
        if(seats<=0 || bags<0 || BASE_FEE<0){
            throw new IllegalArgumentException("Seats and Bags and BASE_FEE can't be 0 or less.");
        }
        this.seats = seats;
        this.bags = bags;
        this.BASE_FEE = BASE_FEE;
    }

    @Override
    public BigDecimal getPrice() {
        double total = BASE_FEE  * seats + (BAG_FEE * bags);
        return BigDecimal.valueOf(total);
    }
}
