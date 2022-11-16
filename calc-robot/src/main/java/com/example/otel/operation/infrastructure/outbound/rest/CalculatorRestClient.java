package com.example.otel.operation.infrastructure.outbound.rest;

import com.example.otel.operation.infrastructure.outbound.request.CalculatorOperation;
import com.example.otel.operation.infrastructure.outbound.response.CalculatorReponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RegisterRestClient(configKey = "calculator-api")
@Path("/calculator")
public interface CalculatorRestClient {

  @POST
  public CalculatorReponse calculate(CalculatorOperation op);

}
