package com.example.otel.calculator.service;

import com.example.otel.calculator.exception.CalculatorOperationNotFoundException;
import com.example.otel.calculator.request.Operation;
import com.example.otel.calculator.response.CalculatorResponse;
import com.example.otel.core.application.request.Operators;
import com.example.otel.core.application.response.BaseResponse;
import com.example.otel.outbound.div.rest.DivRestClient;
import com.example.otel.outbound.sum.rest.SumRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorService {

  SumRestClient sumClient;
  DivRestClient divClient;

  Logger logger = LoggerFactory.getLogger(CalculatorService.class);

  public CalculatorService(@RestClient SumRestClient sumClient, @RestClient DivRestClient divClient) {
    this.sumClient = sumClient;
    this.divClient = divClient;
  }

  public CalculatorResponse calculate(Operation op){
    var response = new CalculatorResponse();
    logger.info("Calculating {} with {} and {}",op.type,op.operator1,op.operator2);
    switch (op.type){
      case SUM:
        response = fromClientResponse(sumClient.sum(fromOperation(op)));
        break;
      case DIV:
        response = fromClientResponse(divClient.div(fromOperation(op)));
        break;
      default:
        throw new CalculatorOperationNotFoundException();
    }
    return response;
  }

  private Operators fromOperation(Operation op){
    var ops = new Operators();
    ops.operator1=op.operator1;
    ops.operator2=op.operator2;
    return ops;
  }

  private CalculatorResponse fromClientResponse(BaseResponse res){
    var response = new CalculatorResponse(res.getResult(),res.getStatusCode());
    return response;
  }


}
