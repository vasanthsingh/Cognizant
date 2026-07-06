package com.cognizant.country_code.service;

import com.cognizant.country_code.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    public Country getCountry(String code){
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countries");
        for(Country country : countries){
            if(country.getCode().equalsIgnoreCase(code)){
                return country;
            }
        }
        throw new RuntimeException("Country with code : " + code + " not found");
    }
}
