package com.nusiss.tfip.TfipSsfAssessment.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DeliveryDetails extends OrderForm {
  
  @NotNull(message = "Name is mandatory")
  @Size(min = 3, message = "Name must be minimum 3 characters")
  private String name;

  @NotNull(message = "Address is mandatory")
  private String address;

  @NotNull(message = "Phone number is mandatory")
  @Size(min = 8, message = "Phone number must be at least 8 digit.")
  private String phone;

  private Boolean rush;

  private String comment;

  private OrderForm orderForm;

  public DeliveryDetails() {
  }

  public DeliveryDetails(String name, String address, String phone, Boolean rush, String comment) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.rush = rush;
    this.comment = comment;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Boolean getRush() {
    return rush;
  }

  public void setRush(Boolean rush) {
    this.rush = rush;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public OrderForm getOrderForm() {
    return orderForm;
  }

  public void setOrderForm(OrderForm orderForm) {
    this.orderForm = orderForm;
  }

  public String getId(){
   return id;    
  }



  
  
}
