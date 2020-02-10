package com.base22.tacocloudtraining.Model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
public class Taco {


    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;


    @ManyToMany(targetEntity=Ingredient.class,cascade = CascadeType.REMOVE)
    @Size(min=1, message="You must choose at least 1 ingredient")
    @NotNull
    private List<Ingredient> ingredients;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Date createdAt;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }


    @Override
    public String toString() {
        return "Taco{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", id=" + id +
                ", createdAt=" + createdAt +
                '}';
    }
}