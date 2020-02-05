package com.base22.tacocloudtraining.Model;

public class Ingredient {



    private final String id;
    private final Type type;
    private final String name;


    public static enum Type{
        WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
    }


    public Ingredient(String id,String name, Type type) {
        this.id = id;
        this.type = type;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }

}
