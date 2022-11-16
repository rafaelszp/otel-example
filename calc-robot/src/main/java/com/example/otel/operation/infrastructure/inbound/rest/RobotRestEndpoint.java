package com.example.otel.operation.infrastructure.inbound.rest;

import com.example.otel.operation.application.manager.OperationManager;
import com.example.otel.operation.application.response.OperationResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/robot")
public class RobotRestEndpoint {

  OperationManager operationManager;

  @Inject
  public RobotRestEndpoint(OperationManager operationManager) {
    this.operationManager = operationManager;
  }

  @GET
  public OperationResponse bulk(){
   return operationManager.bulk();
  }

  @GET
  @Path("/search/{op}")
  public OperationResponse searchByOperation(@PathParam("op") String operation){
    return operationManager.searchByOperation(operation.toUpperCase());
  }




}
