package com.example.otel.outbound.div.rest;

import com.example.otel.core.application.request.Operators;
import com.example.otel.outbound.div.response.DivResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("div")
@RegisterRestClient(configKey = "div-calculator-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DivRestClient {

  @POST
  public DivResponse div(Operators op);
}
