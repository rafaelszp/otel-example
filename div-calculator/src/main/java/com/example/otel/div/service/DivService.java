package com.example.otel.div.service;

import com.example.otel.div.entity.Div;
import com.example.otel.div.exception.OperationNotAllowedException;
import com.example.otel.div.exception.OperatorNotFoundException;
import com.example.otel.div.response.DivResponse;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.Random;

@ApplicationScoped
public class DivService {

   Random  rnd = new Random();

@WithSpan
  @Transactional
  public DivResponse div(@SpanAttribute(value = "op1") Integer op1, @SpanAttribute(value = "op2") Integer op2){
    var o1 = Div.<Div>findByIdOptional(op1).orElseThrow(OperatorNotFoundException::new);
    var o2 = Div.<Div>findByIdOptional(op2).orElseThrow(OperatorNotFoundException::new);

    if(o2.number==0){
      throw new OperationNotAllowedException();
    }
    var r =  new DivResponse(o1.number / o2.number, Response.Status.OK.getStatusCode());
    longTransactionSimulation();
    return r;
  }
  @WithSpan
  public DivResponse findOperator(@SpanAttribute(value = "op") Integer op){
    var o1 = Div.<Div>findByIdOptional(op).orElseThrow(OperatorNotFoundException::new);
    return new DivResponse(o1.number,200);
  }

  @WithSpan
  void longTransactionSimulation(){
    int delay = rnd.nextInt(5000);
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
    }
  }

}
