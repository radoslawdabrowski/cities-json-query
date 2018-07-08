package pl.radoslawdabrowski.cities.citiesjsonquery.entities;

import lombok.Data;

@Data
public class Error {

    private String message;
    private int code;

    public Error(String message, int code) {
        setCode(code);
        setMessage(message);
    }

}
