package org.gridgain.demo.springdata.service;

import java.util.ArrayList;
import java.util.List;
import javax.cache.Cache;
import org.gridgain.demo.springdata.dao.CityRepository;
import org.gridgain.demo.springdata.dao.CountryRepository;
import org.gridgain.demo.springdata.model.City;
import org.gridgain.demo.springdata.model.CityKey;
import org.gridgain.demo.springdata.model.Country;
import org.gridgain.demo.springdata.model.CityDTO;
import org.gridgain.demo.springdata.model.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldDatabaseService {
    @Autowired CountryRepository countryDao;

    @Autowired CityRepository cityDao;

    public List<CountryDTO> getCountriesByPopulation(int population) {
        List<CountryDTO> countries = new ArrayList<>();

        for (Cache.Entry<String, Country> entry: countryDao.findByPopulationGreaterThanEqualOrderByPopulationDesc(population))
            countries.add(new CountryDTO(entry.getKey(), entry.getValue()));

        return countries;
    }

    public List<CityDTO> getCitiesByPopulation(int population) {
        List<CityDTO> cities = new ArrayList<>();

        for (Cache.Entry<CityKey, City> entry: cityDao.findAllByPopulationGreaterThanEqualOrderByPopulation(population))
            cities.add(new CityDTO(entry.getKey(), entry.getValue()));

        return cities;
    }

    public List<List<?>> getMostPopulatedCities(Integer limit) {
        List<List<?>> entries = cityDao.findMostPopulatedCities(limit == null ? 5 : limit);

        return entries;
    }

    public CityDTO updateCityPopulation(int cityId, int population) {
        Cache.Entry<CityKey, City> entry = cityDao.findById(cityId);

        entry.getValue().setPopulation(population);

        cityDao.save(entry.getKey(), entry.getValue());

        return new CityDTO(entry.getKey(), entry.getValue());
    }
}