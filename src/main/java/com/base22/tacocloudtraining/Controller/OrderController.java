package com.base22.tacocloudtraining.Controller;


import com.base22.tacocloudtraining.Model.Order;
import com.base22.tacocloudtraining.Repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }


    @PostMapping
    public String processOrder(@Valid @ModelAttribute("order") Order order, Errors errors, SessionStatus sessionStatus) {

        if (errors.hasErrors()){
            return "orderForm";
        }

        Order saved = orderRepo.save(order);
        log.info(saved.toString());
        sessionStatus.setComplete();
        return "redirect:/";
    }

}

