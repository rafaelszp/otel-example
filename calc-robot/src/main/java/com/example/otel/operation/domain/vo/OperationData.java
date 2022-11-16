package com.example.otel.operation.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OperationData {

  @Column(name="type",nullable = false)
  public String type;

  @Column(name="operator1",nullable = false)
  public Integer operator1;

  @Column(name="operator2",nullable = false)
  public Integer operator2;
}
