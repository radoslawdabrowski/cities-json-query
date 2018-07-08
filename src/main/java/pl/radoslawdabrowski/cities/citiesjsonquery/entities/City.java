package pl.radoslawdabrowski.cities.citiesjsonquery.entities;

import lombok.Data;

import java.util.HashMap;

@Data
public class City {

    private Integer id;
    private String name;
    private String country;
    private HashMap<String, Double> coord;

}
