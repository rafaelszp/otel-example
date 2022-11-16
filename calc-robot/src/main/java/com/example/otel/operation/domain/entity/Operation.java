package com.example.otel.operation.domain.entity;

import com.example.otel.operation.domain.vo.OperationData;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATION")
public class Operation extends PanacheEntityBase {

  @Id
  public Integer id;

  @Embedded
  public OperationData data;
}
