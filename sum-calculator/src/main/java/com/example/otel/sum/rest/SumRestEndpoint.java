package com.example.otel.sum.rest;

import com.example.otel.sum.request.Operators;
import com.example.otel.sum.response.SumResponse;
import com.example.otel.sum.service.SumService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("sum")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SumRestEndpoint {

  @Inject
  SumService sumService;

  @POST
  public SumResponse sum(Operators op) {
    return sumService.sum(op.operator1, op.operator2);
  }

  @GET
  @Path("/op/{id:\\d+}")
  public SumResponse findOperator(@PathParam("id") Integer id){
    return sumService.findOperator(id);
  }

}
