package com.example.otel.sum.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUM_DATA")
public class Sum extends PanacheEntityBase implements Cloneable {

  @Id
  @Column(name="VALUE")
  public Integer number;

}
