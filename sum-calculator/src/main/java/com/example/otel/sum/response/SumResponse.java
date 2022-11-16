package com.example.otel.sum.response;

import com.example.otel.core.application.response.BaseResponse;

public class SumResponse extends BaseResponse<Integer> {

  private Integer result;

  public SumResponse() {
  }

  public SumResponse(Integer result,Integer code) {
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
