package com.codecool.Model;

import java.math.BigDecimal;

public class ExcursionBooking extends CancellableBooking{

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
    public BigDecimal getPrice() {
        return ((BigDecimal.valueOf(BASE_FEE).multiply(BigDecimal.valueOf(adults))) .add (BigDecimal.valueOf(BASE_FEE_PER_CHILD).multiply(BigDecimal.valueOf(children)))) ;
}


}
