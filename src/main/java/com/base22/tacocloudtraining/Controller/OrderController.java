package com.base22.tacocloudtraining.Controller;


import com.base22.tacocloudtraining.Model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {



    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("order", new Order());
    }
    @GetMapping("/current")
    public String orderForm(Model model) {
        return "orderForm";
    }


    @PostMapping
    public String processOrder(@Valid  @ModelAttribute ("order") Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order submitted: " + order);
        return "redirect:/";
    }

}

