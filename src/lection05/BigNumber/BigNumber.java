package lection05.BigNumber;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

public class BigNumber {
    private static final int DIMENSION_AFTER_COMMA = 5;
    BigDecimal firstBigDecimal;
    BigDecimal secondBigDecimal;

    public BigNumber(int firstInteger, int secondInteger) {
        this.firstBigDecimal = new BigDecimal(firstInteger);
        this.secondBigDecimal = new BigDecimal(secondInteger);
    }

    public BigNumber(double firstDouble, double secondDouble) {
        this.firstBigDecimal = new BigDecimal(Double.toString(firstDouble));
        this.secondBigDecimal = new BigDecimal(Double.toString(secondDouble));
    }

    public BigNumber(BigDecimal firstBigDecimal, BigDecimal secondBigDecimal) {
        this.firstBigDecimal = firstBigDecimal;
        this.secondBigDecimal = secondBigDecimal;
    }

    /*сумма*/
    public BigDecimal sum() {
        return firstBigDecimal.add(secondBigDecimal);
    }

    /*деление*/
    public BigDecimal divide() {
        return firstBigDecimal.divide(secondBigDecimal, DIMENSION_AFTER_COMMA, ROUND_HALF_UP); //
    }

    /*разность*/
    public BigDecimal subtract() {
        return firstBigDecimal.subtract(secondBigDecimal);
    }

    /*произведение*/
    public BigDecimal multiply() {
        return firstBigDecimal.multiply(secondBigDecimal);
    }
}
