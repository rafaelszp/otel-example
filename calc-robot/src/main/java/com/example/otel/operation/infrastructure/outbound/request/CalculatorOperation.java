package com.example.otel.operation.infrastructure.outbound.request;

public class CalculatorOperation {

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


}
