package com.example.otel.calculator.exception;

public class CalculatorOperationNotFoundException extends CalculatorException {
  public CalculatorOperationNotFoundException() {
    super("Operation not found or not implemented", 404);
  }
}
