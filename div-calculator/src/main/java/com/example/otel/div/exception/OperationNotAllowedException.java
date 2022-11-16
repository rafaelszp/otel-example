package com.example.otel.div.exception;

public class OperationNotAllowedException extends DivException{

  public OperationNotAllowedException() {
    super("This operation is not allowed. Likely to be an division by zero", 422);
  }
}
