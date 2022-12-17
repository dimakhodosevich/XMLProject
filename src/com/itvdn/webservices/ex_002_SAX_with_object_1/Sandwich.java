package com.itvdn.webservices.ex_002_SAX_with_object_1;

import java.util.ArrayList;

public class Sandwich {
    private String name;
    private ArrayList<String> ingridients;
    private double cost;
    private double weight;

    public Sandwich() {
        name = "No name";
        ingridients = new ArrayList<>();
        cost = 0;
        weight = 0;
    }

    public Sandwich(String name, ArrayList<String> ingridients, double cost, double weight) {
        this.name = name;
        this.ingridients = ingridients;
        this.cost = cost;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getIngridient() {
        return ingridients;
    }

    public void setIngridient(ArrayList<String> ingridients) {
        this.ingridients = ingridients;
    }

    public void addIngridient(String ingridient) {
        ingridients.add(ingridient);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "name='" + name + '\'' +
                ", ingridient=" + ingridients.toString() +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
