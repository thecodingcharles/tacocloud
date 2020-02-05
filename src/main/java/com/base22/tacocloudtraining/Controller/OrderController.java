package com.base22.tacocloudtraining.Controller;


import com.base22.tacocloudtraining.Model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }
}



git commit -m "Added  Order class to hold information about a placed Order. Added post mapping into DesignController to handle the post of a taco design. Added  Order Controller to handle post of an order.Added lombok dependency to use the Logger SLF4J. Created thymeleaf template backedup by a Order object"