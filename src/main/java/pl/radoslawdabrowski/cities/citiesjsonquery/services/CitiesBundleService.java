package pl.radoslawdabrowski.cities.citiesjsonquery.services;

import pl.radoslawdabrowski.cities.citiesjsonquery.entities.City;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.CityDto;

import java.util.ArrayList;

public interface CitiesBundleService {

    ArrayList<City> getList();
    ArrayList<CityDto> findCityByName(String name);

}
