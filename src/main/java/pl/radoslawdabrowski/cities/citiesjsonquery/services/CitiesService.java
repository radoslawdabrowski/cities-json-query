package pl.radoslawdabrowski.cities.citiesjsonquery.services;

import pl.radoslawdabrowski.cities.citiesjsonquery.entities.City;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.CityDto;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.result.Meta;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.result.Pagination;

import java.util.ArrayList;

public interface CitiesService {

    ArrayList<City> getAll();
    ArrayList<CityDto> search(String phrase);

    Pagination paginate(Meta meta);

}
