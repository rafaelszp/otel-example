package com.example.otel.outbound.sum.rest;

import com.example.otel.core.application.request.Operators;
import com.example.otel.outbound.sum.response.SumResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("sum")
@RegisterRestClient(configKey = "sum-calculator-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface SumRestClient {

  @POST
  public SumResponse sum(Operators op);
}
