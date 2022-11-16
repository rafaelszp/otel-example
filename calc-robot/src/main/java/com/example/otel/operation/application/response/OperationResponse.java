package com.example.otel.operation.application.response;

import com.example.otel.core.application.response.BaseResponse;
import com.example.otel.operation.application.ResultDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationResponse extends BaseResponse {

  public List<ResultDTO> results;


}
