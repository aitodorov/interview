package com.softwareag.calculator;

import com.softwareag.calculator.exception.CalculatorException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) throws CalculatorException {
		SpringApplication.run(CalculatorApplication.class, args);
		System.out.println(Calculator.eval("(1+(1+(1)))"));
		System.out.println(Calculator.eval("(((1)+1)+1)"));
	}
}
