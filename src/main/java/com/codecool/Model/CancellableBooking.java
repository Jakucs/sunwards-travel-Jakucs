package com.codecool.Model;

import java.math.BigDecimal;

public abstract class CancellableBooking extends Booking implements Refundable{

    private boolean isCancelled;



    @Override
    public BigDecimal cancel(int daysRemaining) {
        if(daysRemaining<0){
            throw new IllegalArgumentException("Days remaining can't be negative");
        } else if (isCancelled){
            throw new IllegalArgumentException("A reservation can't be canceled twice.");
        }
        if(daysRemaining>14){
            this.isCancelled=true;
            return getPrice().multiply(BigDecimal.valueOf(0.80));
        } else {
            this.isCancelled=true;
            return getPrice().multiply(BigDecimal.valueOf(0.25));
        }
    }

    @Override
    public boolean getIsCancelled() {
        return isCancelled;
    }
}
