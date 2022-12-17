package com.itvdn.webservices.ex_003_SAX_with_object_2.entity;

public class Country {

    private String countryCode;
    private String name;
    private String capital;
    private int population;

    public Country() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country: " +
                "countryCode = " + countryCode +
                ", name = " + name +
                ", capital = " + capital +
                ", population = " + population;
    }
}
