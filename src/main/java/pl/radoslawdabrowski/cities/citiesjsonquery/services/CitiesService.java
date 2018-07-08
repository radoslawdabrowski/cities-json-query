package pl.radoslawdabrowski.cities.citiesjsonquery.services;

import pl.radoslawdabrowski.cities.citiesjsonquery.entities.City;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.CityDto;

import java.util.ArrayList;

public interface CitiesService {

    ArrayList<City> getAll();
    ArrayList<CityDto> search(String phrase);

}
