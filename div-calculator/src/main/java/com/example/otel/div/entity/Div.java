package com.example.otel.div.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIV_DATA")
public class Div extends PanacheEntityBase implements Cloneable {

  @Id
  @Column(name="VALUE")
  public Integer number;

}
