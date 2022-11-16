package com.example.otel.sum.service;

import com.example.otel.sum.entity.Sum;
import com.example.otel.sum.exception.OperatorNotFoundException;
import com.example.otel.sum.response.SumResponse;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class SumService {


  @WithSpan
  @Transactional
  public SumResponse sum(@SpanAttribute("operator-1") Integer op1, @SpanAttribute("operator-2") Integer op2){
    var o1 = Sum.<Sum>findByIdOptional(op1).orElseThrow(OperatorNotFoundException::new);
    var o2 = Sum.<Sum>findByIdOptional(op2).orElseThrow(OperatorNotFoundException::new);
    return new SumResponse(o1.number+o2.number, Response.Status.OK.getStatusCode());
  }

  public SumResponse findOperator(Integer op){
    var o1 = Sum.<Sum>findByIdOptional(op).orElseThrow(OperatorNotFoundException::new);
    return new SumResponse(o1.number,200);
  }

}
