package org.gridgain.demo.springdata.model;

public class CountryDTO {
    private String code;

    private String name;

    private String continent;

    private String region;

    private int population;

    public CountryDTO() {
    }

    public CountryDTO(String key, Country value) {
        this.code = key;
        this.name = value.getName();
        this.continent = value.getContinent();
        this.region = value.getRegion();
        this.population = value.getPopulation();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }
}