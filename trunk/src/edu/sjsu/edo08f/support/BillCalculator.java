package edu.sjsu.edo08f.support;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class BillCalculator {

    public static final double PRICE_RESIDENT_UNDER_6 = 456.00;
    public static final double PRICE_RESIDENT_ABOVE_6 = 786.00;
    public static final double UNIT_PRICE_NONRESIDENT = 282.00;
    public static final double MANDATORY_FEES = 243.60;


    public static double getCalculatedValue (double numberOfUnits, boolean isCaliforniaResident) {
        if (isCaliforniaResident) {
            if (numberOfUnits <= 6) {
                return PRICE_RESIDENT_UNDER_6 + MANDATORY_FEES;
            } else {
                return PRICE_RESIDENT_ABOVE_6 + MANDATORY_FEES;
            }
        } else {
            return numberOfUnits * UNIT_PRICE_NONRESIDENT + MANDATORY_FEES;
        }
    }

}
