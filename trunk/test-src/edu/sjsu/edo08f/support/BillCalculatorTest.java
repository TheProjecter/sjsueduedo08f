package edu.sjsu.edo08f.support;

import org.testng.annotations.Test;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 18, 2008
 */
public class BillCalculatorTest {

    @Test(groups = {"main"})

    public void getCalculatedValueTest() {
        assert (BillCalculator.getCalculatedValue(5.0, true) == 699.6);
      }
    

}
