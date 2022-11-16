package com.example.otel.div.rest;

import com.example.otel.div.request.Operators;
import com.example.otel.div.response.DivResponse;
import com.example.otel.div.service.DivService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("div")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DivRestEndpoint {

  @Inject
  DivService divService;

  @POST
  public DivResponse div(Operators op) {
    return divService.div(op.operator1, op.operator2);
  }

  @GET
  @Path("/op/{id:\\d+}")
  public DivResponse findOperator(@PathParam("id") Integer id){
    return divService.findOperator(id);
  }

}
