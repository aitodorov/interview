package com.softwareag.calculator;

import com.softwareag.calculator.exception.CalculatorException;
import com.softwareag.calculator.parser.generated.Arithmetic;
import com.softwareag.calculator.parser.generated.ParseException;
import com.softwareag.calculator.parser.generated.TokenMgrError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class Calculator {
    private static Logger logger = LoggerFactory.getLogger(Calculator.class);
    
    /**
     * Evaluates an arithmetic expression
     *
     * @param expression the arithmetic expression to be evaluated
     * @return the value of the expression
     * @throws CalculatorException
     */
    public static int eval(String expression) throws CalculatorException {
        if (expression == null) {
            throw new CalculatorException("Expression cannot be null");
        }
        if (expression.contains(";")) {
            throw new CalculatorException("Expression cannot contain ';'");
        }
        expression += ";";

        try (ByteArrayInputStream stream = new ByteArrayInputStream(expression.getBytes())) {
            Arithmetic arithmetic = new Arithmetic(stream);
            return arithmetic.eval();
        } catch (ParseException e) {
            logger.error("Error during parsing", e);
            throw new CalculatorException("Error during parsing", e);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw new CalculatorException(e.toString(), e);
        } catch (TokenMgrError e) {
            logger.error("Error during the lexical analysis", e);
            throw new CalculatorException("Error during the lexical analysis", e);
        }
    }
}
