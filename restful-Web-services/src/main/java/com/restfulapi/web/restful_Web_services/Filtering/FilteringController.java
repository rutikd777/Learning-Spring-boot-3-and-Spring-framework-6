package com.restfulapi.web.restful_Web_services.Filtering;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //Static filtering
    @GetMapping("/filter")
    public SomeBean filtering(){
        return  new SomeBean("value1","value2","value3","value4");
    }

    @GetMapping("/filter-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("value1","value2","value3","value4"),new SomeBean("value5","value6","value7","value8") );
    }

    //DYNAMIC Filtering
    @GetMapping("/filtering")
    public MappingJacksonValue dynamicFiltering(){

        SomeBean someBean = new SomeBean("value1","value2","value3","value4");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue dynamicFilteringList(){

        List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3","value4"),new SomeBean("value5","value6","value7","value8") );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}
