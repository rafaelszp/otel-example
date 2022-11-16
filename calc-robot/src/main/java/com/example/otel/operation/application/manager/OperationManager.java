package com.example.otel.operation.application.manager;

import com.example.otel.operation.application.ResultDTO;
import com.example.otel.operation.application.response.OperationResponse;
import com.example.otel.operation.domain.entity.Operation;
import com.example.otel.operation.infrastructure.outbound.rest.CalculatorRestClient;
import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Random;

import com.example.otel.operation.infrastructure.outbound.request.CalculatorOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class OperationManager {

  Logger logger = LoggerFactory.getLogger(OperationManager.class);
  @RestClient
  private CalculatorRestClient calculatorClient;


  public OperationResponse bulk() {
    var ops = Operation.<Operation>findAll();
    var response = new OperationResponse();
    response.results = new ArrayList<>();
    ops.list().forEach(op -> {
      var result = ResultDTO.fromOperation(op);
      var operation = new CalculatorOperation();
      operation.operator1=op.data.operator1;
      operation.operator2=op.data.operator2;
      operation.type= CalculatorOperation.OperationType.valueOf(op.data.type);
      try {
        logger.info("Sending {} operation with [{}] and [{}] operators",op.data.type,op.data.operator1,op.data.operator2);
        result.result = calculatorClient.calculate(operation).result;
        Random rnd = new Random();
        Thread.sleep(rnd.nextInt(200));
      } catch (Exception e) {
        result.result = 500;
      }
      response.results.add(result);
    });
    return response;
  }

  @Scheduled(every = "10m")
  public void executeFirst(){
    var first = Operation.<Operation>findAll().firstResult();
    var operation = new CalculatorOperation();
    operation.operator1=first.id;
    operation.operator2=2;
    operation.type= CalculatorOperation.OperationType.DIV;
    var result = calculatorClient.calculate(operation);

    logger.info("result {}",result.result);

  }

  public OperationResponse searchByOperation(String name) {
    var list = Operation.<Operation>list("type",name);
    var res = new OperationResponse();
    res.results=new ArrayList<>();
    list.forEach(operation -> res.results.add(ResultDTO.fromOperation(operation)));
    return res;
  }
}
