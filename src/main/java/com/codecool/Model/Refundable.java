package com.codecool.Model;

import java.math.BigDecimal;

public interface Refundable {

    public BigDecimal cancel(int daysRemaining);

    public boolean getIsCancelled();
}
