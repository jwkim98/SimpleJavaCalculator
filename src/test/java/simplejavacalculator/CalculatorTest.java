package simplejavacalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculateBi() {
        Calculator cal = new Calculator();
        cal.reset();
        cal.calculateBi(Calculator.BiOperatorModes.add, 3.44);
        assertEquals(cal.calculateEqual(3.21), new Double(6.65));
    }

//    @Test
//    public void calculateEqual() {
//    }
//
//    @Test
//    public void reset() {
//    }
//
//    @Test
//    public void calculateMono() {
//    }
}