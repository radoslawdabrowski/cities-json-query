package pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {

    private Integer current;
    private Integer items;
    private Integer pages;

    public Meta() {}

    public Meta(int current, int items) {
        setCurrent(current);
        setItems(items);
    }

}
