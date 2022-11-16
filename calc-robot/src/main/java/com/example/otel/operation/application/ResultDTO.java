package com.example.otel.operation.application;

import com.example.otel.operation.domain.entity.Operation;

public class ResultDTO {
  public String type;
  public Integer operator1;
  public Integer operator2;
  public Integer result;

  public static ResultDTO fromOperation(Operation op){
    var result = new ResultDTO();
    result.type=op.data.type;
    result.operator1=op.data.operator1;
    result.operator2=op.data.operator2;
    return result;
  }

}
