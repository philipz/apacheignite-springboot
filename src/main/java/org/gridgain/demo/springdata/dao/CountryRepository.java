package org.gridgain.demo.springdata.dao;

import java.util.List;
import javax.cache.Cache;
import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.gridgain.demo.springdata.model.Country;
import org.springframework.stereotype.Repository;

@RepositoryConfig (cacheName = "Country")
@Repository
public interface CountryRepository extends IgniteRepository<Country, String> {

    public List<Cache.Entry<String,Country>> findByPopulationGreaterThanEqualOrderByPopulationDesc(int population);
}