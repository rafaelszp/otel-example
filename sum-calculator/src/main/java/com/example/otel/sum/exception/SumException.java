package com.example.otel.sum.exception;

import javax.ws.rs.WebApplicationException;

public class SumException extends WebApplicationException {
  private int code;
  private String message;

  public SumException(String message, int code) {
    super(message, code);
    this.code = code;
    this.message = message;
  }
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
