package com.rajukrsoni.rest.webservices.restfull_we_bservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.DynamicFilteringResponse;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.StaticFilteringResponse;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public StaticFilteringResponse filtering(){
        return new StaticFilteringResponse("user1", "user2", "user3");
    }

    @GetMapping(path = "/filtering-list")
    public List<StaticFilteringResponse> filteringList(){
        return Arrays.asList(new StaticFilteringResponse("value1", "value2", "value3"),
                new StaticFilteringResponse("value4", "value5", "value6"));
    }

    @GetMapping(path = "/filtering-dynamic")
    public MappingJacksonValue filteringDynamic(){

        DynamicFilteringResponse dynamicFilteringResponse = new DynamicFilteringResponse("user1", "user2", "user3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilteringResponse);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping(path = "/filtering-dynamic-list")
    public MappingJacksonValue filteringDynamicList(){

        List<DynamicFilteringResponse> list = Arrays.asList(new DynamicFilteringResponse("value1", "value2", "value3"),
                new DynamicFilteringResponse("value4", "value5", "value6"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
