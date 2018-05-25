package lection05;

import lection05.BigNumber.BigNumber;

import java.math.BigDecimal;

public class MainClassForLection5 {
    public static void main(String[] args) {
        BigDecimal decimal1 = new BigDecimal("2100000.560006");
        BigDecimal decimal2 = new BigDecimal("2132132.564546");
        Double double1 = Double.valueOf("12.2");
        Double double2 = Double.valueOf("11.2");
        Integer integer1 = Integer.valueOf("12");
        Integer integer2 = Integer.valueOf("1123");
//
        BigNumber bigNumberInteger = new BigNumber(integer1, integer2);
        BigNumber bigNumberDouble = new BigNumber(double1, double2);
        BigNumber bigNumberDecimal = new BigNumber(decimal1, decimal2);
//
        System.out.println("sum decimal: " + bigNumberDecimal.sum() + " divide decimal : " + bigNumberDecimal.divide());
        System.out.println("sum double: " + bigNumberDouble.sum() + " divide double : " + bigNumberDouble.divide());
        System.out.println("sum integer: " + bigNumberInteger.sum() + " integer decimal : " + bigNumberInteger.divide());

    }
}
