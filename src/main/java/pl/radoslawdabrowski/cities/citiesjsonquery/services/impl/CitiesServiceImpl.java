package pl.radoslawdabrowski.cities.citiesjsonquery.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.City;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.CityDto;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.result.Meta;
import pl.radoslawdabrowski.cities.citiesjsonquery.entities.dto.result.Pagination;
import pl.radoslawdabrowski.cities.citiesjsonquery.handlers.PageableHandler;
import pl.radoslawdabrowski.cities.citiesjsonquery.services.CitiesBundleService;
import pl.radoslawdabrowski.cities.citiesjsonquery.services.CitiesService;

import java.util.ArrayList;

@Service
public class CitiesServiceImpl implements CitiesService {

    private final CitiesBundleService bundle;

    @Autowired
    public CitiesServiceImpl(CitiesBundleService bundle) {
        this.bundle = bundle;
    }

    @Override
    public ArrayList<City> getAll() {
        return bundle.getList();
    }

    @Override
    public ArrayList<CityDto> search(String phrase) {
        if(!StringUtils.isEmpty(phrase))
            return bundle.findCityByName(phrase);
        else
            return new ArrayList<>();
    }

    @Override
    public Pagination paginate(Meta meta) {
        ArrayList<City> list = getAll();
        Pagination pg = new Pagination(new Meta());

        PageableHandler<City> pageable = new PageableHandler<>(list);
        pageable.setPageSize(meta.getItems());
        pageable.setPage(meta.getCurrent());

        pg.getMeta().setPages(pageable.getMaxPages());
        pg.getMeta().setItems(pageable.getPageSize());
        pg.getMeta().setCurrent(meta.getCurrent());
        pg.setData(pageable.getListForPage());
        return pg;
    }

}
