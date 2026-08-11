package com.codecool.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilityMoney {

    public static BigDecimal makeDecimal(double num){
        return BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_UP);
    }
}
