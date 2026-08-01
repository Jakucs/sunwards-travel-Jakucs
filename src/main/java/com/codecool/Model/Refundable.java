package com.codecool.Model;

public interface Refundable {

    public double cancel(int daysRemaining);

    public boolean getIsCancelled();
}
