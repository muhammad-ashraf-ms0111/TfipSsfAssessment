package com.nusiss.tfip.TfipSsfAssessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nusiss.tfip.TfipSsfAssessment.model.DeliveryDetails;
import com.nusiss.tfip.TfipSsfAssessment.model.OrderForm;
import com.nusiss.tfip.TfipSsfAssessment.service.OrderService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class PizzaController {

  @Autowired
  private OrderService ordSvc;


@GetMapping(path="/")
    public String contactForm(Model model){
        model.addAttribute("order", new OrderForm());
        return "index";
    }
 
@PostMapping("/pizza")
  public String saveOrder(@Valid OrderForm order, BindingResult result, 
              Model model, HttpServletResponse response){
      if(result.hasErrors()){
          return "index";
      }
      ordSvc.save(order);
      model.addAttribute( "order", order);
      response.setStatus(HttpServletResponse.SC_CREATED);
      return "deliveryDetails";
  }

  @PostMapping("/pizza/ order")
  public String saveDetails(@Valid DeliveryDetails details, BindingResult result, 
              Model model, HttpServletResponse response){
      if(result.hasErrors()){
          return "index";
      }
      ordSvc.save(details);
      model.addAttribute( "details", details);
      response.setStatus(HttpServletResponse.SC_CREATED);
      return "showDetails";
  }

}

