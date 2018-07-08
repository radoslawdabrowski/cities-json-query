package pl.radoslawdabrowski.cities.citiesjsonquery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.radoslawdabrowski.cities.citiesjsonquery.constraints.Directory;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.City;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.CityDto;
import pl.radoslawdabrowski.cities.citiesjsonquery.services.CitiesService;

import java.util.ArrayList;

@RestController
@RequestMapping(path = Directory.URI_CITIES)
public class CitiesController {

    private final CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping(path = Directory.URI_CITIES_LIST)
    public ArrayList<City> list() {
        return citiesService.getAll();
    }

    @GetMapping(path = Directory.URI_CITIES_SEARCH)
    public ArrayList<CityDto> search(@PathVariable(name = "phrase") String phrase){
        return citiesService.search(phrase);
    }

}
