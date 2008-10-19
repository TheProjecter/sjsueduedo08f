package edu.sjsu.edo08f.support;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 18, 2008
 */
public class BillCalculatorTest {

    @Configuration(beforeTestClass = true)
    public void configure() {
        System.out.println("configure");
    }

    @Test(groups = {"exec-group"})
        public void exec() {
        System.out.println("exec");
        assert 1 == 2;
      }
    

}
