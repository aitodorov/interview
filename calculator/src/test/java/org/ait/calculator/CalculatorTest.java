package com.softwareag.calculator;

import org.junit.jupiter.api.Test;
import com.softwareag.calculator.exception.CalculatorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void testSimpleExpressions() throws Exception {
        assertEquals(0, Calculator.eval("0"));
        assertEquals(1, Calculator.eval("1"));
        assertEquals(3, Calculator.eval("1 + 2"));
        assertEquals(1, Calculator.eval("1 + 0"));
        assertEquals(1, Calculator.eval("3 - 2"));
        assertEquals(3, Calculator.eval("3 - 0"));
        assertEquals(6, Calculator.eval("2 * 3"));
        assertEquals(0, Calculator.eval("2 * 0"));
        assertEquals(0, Calculator.eval("0 / 2"));
        assertEquals(1, Calculator.eval("3 / 2"));
        assertEquals(3, Calculator.eval("6 / 2"));
        assertEquals(3, Calculator.eval("6 / 2 / 1"));
        assertEquals(1, Calculator.eval("6 / 2 / 1 / 3"));
    }

    @Test
    void testPrioritiesNoBrackets() throws Exception {
        assertEquals(26, Calculator.eval("2 * 3 + 4 * 5"));
        assertEquals(32, Calculator.eval("2 * 3 + 4 * 5 + 6"));
        assertEquals(68, Calculator.eval("2 * 3 + 4 * 5 + 6 * 7"));

        assertEquals(19, Calculator.eval("2 + 3 * 4 + 5"));
        assertEquals(44, Calculator.eval("2 + 3 * 4 + 5 * 6"));
        assertEquals(51, Calculator.eval("2 + 3 * 4 + 5 * 6 + 7"));

        assertEquals(-14, Calculator.eval("2 * 3 - 4 * 5"));
        assertEquals(-20, Calculator.eval("2 * 3 - 4 * 5 - 6"));
        assertEquals(-56, Calculator.eval("2 * 3 - 4 * 5 - 6 * 7"));

        assertEquals(-15, Calculator.eval("2 - 3 * 4 - 5"));
        assertEquals(-40, Calculator.eval("2 - 3 * 4 - 5 * 6"));
        assertEquals(-47, Calculator.eval("2 - 3 * 4 - 5 * 6 - 7"));

        assertEquals(5, Calculator.eval("4 / 2 + 6 / 2"));
        assertEquals(13, Calculator.eval("4 / 2 + 6 / 2 + 8"));
        assertEquals(9, Calculator.eval("4 / 2 + 6 / 2 + 8 / 2"));
    }

    @Test
    void testPrioritiesBrackets() throws Exception {
        assertEquals(45, Calculator.eval("(2 + 3) * (4 + 5)"));
        assertEquals(270, Calculator.eval("(2 + 3) * (4 + 5) * 6"));
        assertEquals(585, Calculator.eval("(2 + 3) * (4 + 5) * (6 + 7)"));

        assertEquals(1, Calculator.eval("(2 - 3) * (4 - 5)"));
        assertEquals(6, Calculator.eval("(2 - 3) * (4 - 5) * 6"));
        assertEquals(-1, Calculator.eval("(2 - 3) * (4 - 5) * (6 - 7)"));

        assertEquals(8, Calculator.eval("(8 + 8) / (1 + 1)"));
        assertEquals(4, Calculator.eval("(8 + 8) / (1 + 1) / 2"));
        assertEquals(2, Calculator.eval("(8 + 8) / (1 + 1) / (2 +2)"));
        assertEquals(1, Calculator.eval("(8 + 8) / (1 + 1) / (2 +2) / 2"));
    }

    /**
     * Test expressions like these:
     * 1. (int),((int)),(((int))) and
     * (int+int),((int+int)),(((int+int)))
     * <p>
     * 2. (int+(int+(int))) and (((int)+int)+int)
     *
     * @throws Exception
     */
    @Test
    void testBrackets() throws Exception {
        // test (int),((int)),(((int))) and (int+int),((int+int)),(((int+int)))
        int numIterations = 50;
        for (int i = 1; i <= numIterations; i++) {
            StringBuilder singleNumberExp = new StringBuilder("" + i);
            StringBuilder twoNumberExp = new StringBuilder(String.format("%d+%d", i, i));
            for (int j = 0; j < i; j++) {
                singleNumberExp.insert(0, "(").append(")");
                twoNumberExp.insert(0, "(").append(")");
            }
            assertEquals(i, Calculator.eval(singleNumberExp.toString()));
            assertEquals(i + i, Calculator.eval(twoNumberExp.toString()));
        }

        // test (int+(int+(int))) and (((int)+int)+int)
        for (int i = 1; i <= numIterations; i++) {
            StringBuilder exp1 = new StringBuilder("(" + i + ")"); // (int+(int+(int)))
            StringBuilder exp2 = new StringBuilder("(" + i + ")"); // (((int)+int)+int)
            for (int j = 0; j < i; j++) {
                exp1.insert(0, "(" + i + "+").append(")");
                exp2.insert(0, "(").append("+ " + i + ")");
            }
            assertEquals(i * (i + 1), Calculator.eval(exp1.toString()));
            assertEquals(i * (i + 1), Calculator.eval(exp2.toString()));
        }
    }

    @Test
    void testNegativeCases() {
        assertThrows(CalculatorException.class, () -> {
            Calculator.eval(null);
        });

        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("");
        });
        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("   ");
        });

        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("1;1");
        });

        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("x");
        });

        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("02");
        });

        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("(2");
        });

        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("(2^2)");
        });

        // missing closing bracket
        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("(2+(2+(2))");
        });

        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("11111111111111111111111111111111111111111111111111111111111111");
        });

        assertThrows(CalculatorException.class, () -> {
            Calculator.eval("1 / 0");
        });
    }
}
