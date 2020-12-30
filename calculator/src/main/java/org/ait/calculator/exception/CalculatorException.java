package com.softwareag.calculator.exception;

/**
 * The purpose of this exception class is to hide the specific exceptions/errors coming from
 * the generated parser even though these exceptions/errors will be nested into this exception.
 * The calculator itself needs to throw only this exception.
 */
public class CalculatorException extends Exception {
    public CalculatorException(String message, Throwable t) {
        super(message, t);
    }
    
    public CalculatorException(String message) {
        super(message);
    }
}
