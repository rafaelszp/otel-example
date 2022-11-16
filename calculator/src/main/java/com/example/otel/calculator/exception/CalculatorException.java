package com.example.otel.calculator.exception;

import javax.ws.rs.WebApplicationException;

public class CalculatorException extends WebApplicationException {

  public CalculatorException(String message, int status) {
    super(message, status);
  }
}
