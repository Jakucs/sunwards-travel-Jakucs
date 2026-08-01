package com.codecool.Model;

public class ExcursionBooking extends Booking implements Refundable{

    private double BASE_FEE;
    private double BASE_FEE_PER_CHILD;

    private int adults;
    private int children;

    private boolean isCancelled;

    public ExcursionBooking(int adults, int children, double BASE_FEE) {
        super();
        if(adults<0 || children<0 || BASE_FEE<0){
            throw new IllegalArgumentException("Adults can't be negative. Children and BASE_FEE can't be 0 or negative.");
        }
        this.adults = adults;
        this.children = children;
        this.BASE_FEE = BASE_FEE;
        this.BASE_FEE_PER_CHILD = BASE_FEE/2;
        this.isCancelled = false;
    }

    @Override
    public double getPrice() {
        return Math.round(((adults*BASE_FEE) + (children*BASE_FEE_PER_CHILD)) * 100) / 100.0 ;
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
