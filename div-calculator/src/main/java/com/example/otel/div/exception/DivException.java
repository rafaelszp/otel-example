package com.example.otel.div.exception;

import javax.ws.rs.WebApplicationException;

public class DivException extends WebApplicationException {
  private int code;
  private String message;

  public DivException(String message, int code) {
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
