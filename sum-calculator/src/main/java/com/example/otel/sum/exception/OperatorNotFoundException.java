package com.example.otel.sum.exception;

public class OperatorNotFoundException extends SumException{
  public OperatorNotFoundException() {
    super("Operator Not found", 404);
  }
}
