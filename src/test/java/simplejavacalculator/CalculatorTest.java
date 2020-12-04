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

        cal.calculateBi(Calculator.BiOperatorModes.minus, 8.0);
        assertEquals(cal.calculateBi(Calculator.BiOperatorModes.divide, 2.0), new Double(6.0));
        assertEquals(cal.calculateEqual(3.0), new Double(2.0));

        cal.calculateBi(Calculator.BiOperatorModes.multiply, 6.5);
        assertEquals(cal.calculateBi(Calculator.BiOperatorModes.xpowerofy, 7.3), new Double(6.5*7.3));
        assertEquals(cal.calculateEqual(3.0), new Double(Math.pow(6.5*7.3, 3.0)));
    }

    @Test
    public void SquareRoot() {
        Calculator cal = new Calculator();
        cal.reset();
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.squareRoot, 18.49), new Double(4.3));
    }

    @Test
    public void OneDividedBy() {
        Calculator cal = new Calculator();
        cal.reset();
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 0.4), new Double(2.5));
    }

    @Test
    public void Trigonometric() {
        Calculator cal = new Calculator();
        cal.reset();
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.sin, Math.PI/6), new Double(Math.sin(Math.PI/6)));
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.cos, Math.PI/3), new Double(Math.cos(Math.PI/3)));
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.tan, Math.PI/4), new Double(Math.tan(Math.PI/4)));
    }

    @Test
    public void MonoOperator() {
        Calculator cal = new Calculator();
        cal.reset();
        cal.calculateBi(Calculator.BiOperatorModes.add,
                cal.calculateMono(Calculator.MonoOperatorModes.square,
                        cal.calculateMono(Calculator.MonoOperatorModes.cos, 75.0)));
        assertEquals(cal.calculateEqual(cal.calculateMono(Calculator.MonoOperatorModes.square,
                cal.calculateMono(Calculator.MonoOperatorModes.sin, 75.0))), new Double(1.0));

    }
}