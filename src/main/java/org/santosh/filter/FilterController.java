package org.santosh.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.santosh.model.Address;
import org.santosh.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping(value = "/filter-pin", produces = MediaType.APPLICATION_JSON_VALUE)
    public MappingJacksonValue filterEmployeePin() {

        Employee e1 = new Employee("Santosh", "IT", new Date(),
                new Address("GB Marg", "Mumbai", 400013), "Gaming");

        FilterProvider propertyFilter = getPropertyFilter("streetName", "city");
        MappingJacksonValue mappingValue = new MappingJacksonValue(e1);
        mappingValue.setFilters(propertyFilter);

        return mappingValue;
    }

    @GetMapping(value = "filter-street", produces = MediaType.APPLICATION_JSON_VALUE)
    public MappingJacksonValue filterEmployeeStreetNames() {

        Employee e1 = new Employee("Santosh", "IT", new Date(),
                new Address("Parel", "Mumbai", 400013), "Gaming");
        Employee e2 = new Employee("Shiva", "DB", new Date(),
                new Address("Parel", "Mumbai", 400013), "Self Praising");
        List<Employee> list = Arrays.asList(e1, e2);

        FilterProvider propertyFilter = getPropertyFilter("city", "pincode");
        MappingJacksonValue mappingValue = new MappingJacksonValue(list);
        mappingValue.setFilters(propertyFilter);

        return mappingValue;
    }

    private FilterProvider getPropertyFilter(String ... filterProperty) {
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(filterProperty[0], filterProperty[1]);
        FilterProvider provider = new SimpleFilterProvider().addFilter("Filter Pincode", propertyFilter);
        return provider;
    }
}
