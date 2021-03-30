package org.gridgain.demo.springdata.controller;

import java.util.List;
import org.gridgain.demo.springdata.model.CityDTO;
import org.gridgain.demo.springdata.model.CountryDTO;
import org.gridgain.demo.springdata.service.WorldDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldDatabaseController {
    @Autowired WorldDatabaseService service;

    @GetMapping("/api/countries")
    public List<CountryDTO> getCountriesByPopulation(@RequestParam (value = "population", required = true) int population) {
        return service.getCountriesByPopulation(population);
    }

    @GetMapping("/api/cities")
    public List<CityDTO> getCitiesByPopulation(@RequestParam (value = "population", required = true) int population) {
        return service.getCitiesByPopulation(population);
    }

    @GetMapping("/api/cities/mostPopulated")
    public List<List<?>> getMostPopulatedCities(@RequestParam (value = "limit", required = false) Integer limit) {
        return service.getMostPopulatedCities(limit);
    }

    @PutMapping("/api/cities/{id}")
    public CityDTO updateCityPopulation(@PathVariable Integer id, @RequestBody CityDTO cityDTO) {
        return service.updateCityPopulation(id, cityDTO.getPopulation());
    }

}
