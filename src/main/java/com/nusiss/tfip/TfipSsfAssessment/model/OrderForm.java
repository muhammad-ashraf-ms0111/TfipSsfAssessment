package com.nusiss.tfip.TfipSsfAssessment.model;

import java.util.Random;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderForm {
  
  @NotNull(message = "Need to choose a type of pizza")
  private String pizza;
  
  @NotNull(message = "Need to choose a size")
  private String size;
  
  @Min(value = 1, message = "Minimum of 1 pizza")
  @Max(value = 10, message = "Maximum of 10 pizzas")
  private int quantity;

  protected String id;

  public OrderForm() {
    this.id = this.generateId(8);
  }


  public OrderForm(String pizza, String size, int quantity) {
    this.id = this.generateId(8);
    this.pizza = pizza;
    this.size = size;
    this.quantity = quantity;
  }

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

  public String getPizza() {
    return pizza;
  }


  public void setPizza(String pizza) {
    this.pizza = pizza;
  }


  public String getSize() {
    return size;
  }


  public void setSize(String size) {
    this.size = size;
  }


  public int getQuantity() {
    return quantity;
  }


  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
  private synchronized String generateId(int numChars) {
    Random r = new Random();
    StringBuilder sb = new StringBuilder();
    while (sb.length() < numChars) {
        sb.append(Integer.toHexString(r.nextInt()));
    }
    return sb.toString().substring(0, numChars);
}
  

}
