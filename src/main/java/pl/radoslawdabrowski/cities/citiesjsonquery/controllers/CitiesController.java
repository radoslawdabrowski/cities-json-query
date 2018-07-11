package pl.radoslawdabrowski.cities.citiesjsonquery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.radoslawdabrowski.cities.citiesjsonquery.constraints.Directory;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.City;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.CityDto;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.result.Meta;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.result.Pagination;
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

    @PostMapping(path = Directory.URI_CITIES_PAGINATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pagination paginate(@RequestBody Meta meta) {
        return citiesService.paginate(meta);
    }

}
