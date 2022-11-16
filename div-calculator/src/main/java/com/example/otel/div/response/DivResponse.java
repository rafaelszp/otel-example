package com.example.otel.div.response;

import com.example.otel.core.application.response.BaseResponse;

public class DivResponse extends BaseResponse<Integer> {

  private Integer result;

  public DivResponse() {
  }

  public DivResponse(Integer result, Integer code) {
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
