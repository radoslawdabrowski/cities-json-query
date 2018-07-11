package pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto;

import lombok.Data;

@Data
public class CityDto {

    private String name;
    private Integer id;

    public CityDto() {}

    public CityDto(Integer id, String name) {
        setId(id);
        setName(name);
    }

}
