package com.example.otel.calculator.response;

import com.example.otel.core.application.response.BaseResponse;

public class CalculatorResponse extends BaseResponse<Integer> {

  private Integer result;

  public CalculatorResponse() {
  }

  public CalculatorResponse(Integer result,Integer code) {
    this.result = result;
    this.setStatusCode(code);
  }

  public Integer getResult() {
    return result;
  }

  public void setResult(Integer result) {
    this.result = result;
  }
}
