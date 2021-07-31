package com.collaborators.model;

import java.util.Calendar;

public class Collaborator {

  private int id;
  private String name;
  private String email;
  private double wage;
  private Calendar hiring;

  public Collaborator(int id, String name, String email, double wage, Calendar hiring) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.wage = wage;
    this.hiring = hiring;
  }

  public Collaborator() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getWage() {
    return wage;
  }

  public void setWage(double wage) {
    this.wage = wage;
  }

  public Calendar getHiring() {
    return hiring;
  }

  public void setHiring(Calendar hiring) {
    this.hiring = hiring;
  }

}
