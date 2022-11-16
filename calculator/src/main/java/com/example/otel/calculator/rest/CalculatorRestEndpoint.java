package com.example.otel.calculator.rest;

import com.example.otel.calculator.request.Operation;
import com.example.otel.calculator.response.CalculatorResponse;
import com.example.otel.calculator.service.CalculatorService;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("calculator")
public class CalculatorRestEndpoint {


  CalculatorService service;

  @Inject
  public CalculatorRestEndpoint(CalculatorService service) {
    this.service = service;
  }

  @WithSpan
  @POST
  public CalculatorResponse calculate(@SpanAttribute("operation") Operation op){
    return service.calculate(op);
  }



}
