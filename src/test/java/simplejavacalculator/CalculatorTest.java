package simplejavacalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculateBi() {
        Calculator cal = new Calculator();
        cal.reset();
        cal.calculateBi(Calculator.BiOperatorModes.ADD, 3.44);
        assertEquals(cal.calculateEqual(3.21), new Double(6.65));

        cal.calculateBi(Calculator.BiOperatorModes.MINUS, 8.0);
        assertEquals(cal.calculateBi(Calculator.BiOperatorModes.DIVIDE, 2.0), new Double(6.0));
        assertEquals(cal.calculateEqual(3.0), new Double(2.0));

        cal.calculateBi(Calculator.BiOperatorModes.MULTIPLY, 6.5);
        assertEquals(cal.calculateBi(Calculator.BiOperatorModes.XPOWEROFY, 7.3), new Double(6.5*7.3));
        assertEquals(cal.calculateEqual(3.0), new Double(Math.pow(6.5*7.3, 3.0)));
    }

    @Test
    public void SquareRoot() {
        Calculator cal = new Calculator();
        cal.reset();
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.SQUARE_ROOT, 18.49), new Double(4.3));
    }

    @Test
    public void OneDividedBy() {
        Calculator cal = new Calculator();
        cal.reset();
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.ONE_DIVIDED_BY, 0.4), new Double(2.5));
    }

    @Test
    public void Trigonometric() {
        Calculator cal = new Calculator();
        cal.reset();
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.SIN, Math.PI/6), new Double(Math.sin(Math.PI/6)));
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.COS, Math.PI/3), new Double(Math.cos(Math.PI/3)));
        assertEquals(cal.calculateMono(Calculator.MonoOperatorModes.TAN, Math.PI/4), new Double(Math.tan(Math.PI/4)));
    }

    @Test
    public void MonoOperator() {
        Calculator cal = new Calculator();
        cal.reset();
        cal.calculateBi(Calculator.BiOperatorModes.ADD,
                cal.calculateMono(Calculator.MonoOperatorModes.SQUARE,
                        cal.calculateMono(Calculator.MonoOperatorModes.COS, 75.0)));
        assertEquals(cal.calculateEqual(cal.calculateMono(Calculator.MonoOperatorModes.SQUARE,
                cal.calculateMono(Calculator.MonoOperatorModes.SIN, 75.0))), new Double(1.0));

    }
}