package org.gridgain.demo.springdata.model;

public class CityDTO {
    private int id;

    private String countryCode;

    private String name;

    private String district;

    private int population;

    public CityDTO() {
    }

    public CityDTO(CityKey key, City value) {
        this.id = key.getId();
        this.countryCode = key.getCountryCode();
        this.name = value.getName();
        this.district = value.getDistrict();
        this.population = value.getPopulation();
    }

    public int getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }
}
