package com.example.otel.div.exception;

public class OperatorNotFoundException extends DivException {
  public OperatorNotFoundException() {
    super("Operator Not found", 404);
  }
}
