package pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.result;

import lombok.Data;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.City;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pagination {

    private Meta meta;
    private List<City> data = new ArrayList<>();

    public Pagination() {}

    public Pagination(Meta meta) {
        setMeta(meta);
    }

}
