package com.base22.tacocloudtraining.Controller;


import com.base22.tacocloudtraining.Model.Ingredient;
import com.base22.tacocloudtraining.Model.Order;
import com.base22.tacocloudtraining.Model.Taco;
import com.base22.tacocloudtraining.Repository.IngredientRepository;
import com.base22.tacocloudtraining.Repository.TacoRepository;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.base22.tacocloudtraining.Model.Ingredient.Type;

import javax.validation.Valid;


@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignController {

    private final IngredientRepository ingredientRepo;

    private final TacoRepository tacoRepo;

    @Autowired
    public DesignController(IngredientRepository ingredientRepo, TacoRepository tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream()
                            .filter(i -> i.getType() == type).collect(Collectors.toList()));

        }
    }


    @GetMapping
    public String showDesignForm() {
        return "design";
    }


    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco taco, Errors errors, @ModelAttribute("order") Order order) {


        if (errors.hasErrors()) {
            return "design";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        log.info(taco.toString());
        Taco saved = tacoRepo.save(taco);
        order.addTaco(saved);


        return "redirect:/orders/current";
    }

}



