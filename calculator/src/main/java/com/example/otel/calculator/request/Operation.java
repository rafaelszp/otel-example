package com.example.otel.calculator.request;


public class Operation {

  public Integer operator1;
  public Integer operator2;
  public OperationType type;


  public enum OperationType{
    SUM("SUM"),SUB("SUB"),MUL("MUL"),DIV("DIV");

    private String type;
    OperationType(String type) {
      this.type = type;
    }

    public String getType() {
      return type;
    }
  }

  @Override
  public String toString() {
    return "Operation{" +
      "operator1=" + operator1 +
      ", operator2=" + operator2 +
      ", type=" + type +
      '}';
  }
}
