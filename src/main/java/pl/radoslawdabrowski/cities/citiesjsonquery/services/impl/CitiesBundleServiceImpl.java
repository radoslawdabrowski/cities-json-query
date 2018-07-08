package pl.radoslawdabrowski.cities.citiesjsonquery.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.City;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.CityDto;
import pl.radoslawdabrowski.cities.citiesjsonquery.services.CitiesBundleService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class CitiesBundleServiceImpl implements CitiesBundleService {

    private @Getter ArrayList<City> list = new ArrayList<>();
    private Gson gson = new GsonBuilder().create();

    public CitiesBundleServiceImpl() {
        loadJSON();
    }

    private void loadJSON()  {
       try {
           JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(new ClassPathResource("city.list.json").getFile()), UTF_8.name()));
           reader.beginArray();
           while (reader.hasNext())
                   list.add(gson.fromJson(reader, City.class));
           reader.endArray();
           reader.close();
       } catch (IOException ignore) {

       }
    }

    @Override
    public ArrayList<CityDto> findCityByName(String name) {
        return new ArrayList<CityDto>(){
            {
                for(City entity : list)
                    if(entity.getName().toLowerCase().contains(name.toLowerCase()))
                        add(new CityDto(entity.getId(), entity.getName()));
            }
        };
    }
}