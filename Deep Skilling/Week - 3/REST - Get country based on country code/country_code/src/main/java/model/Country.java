package com.cognizant.country_code.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger logger = LoggerFactory.getLogger(Country.class);
    private String name,code;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getName() {
        logger.info("Calling getName function from Country class");
        return name;
    }

    public void setName(String name) {
        logger.info("Calling setName function from Country class with name: {}",name);
        this.name = name;
    }

    public String getCode() {
        logger.info("Calling getCode function from Country class");
        return code;
    }

    public void setCode(String code) {
        logger.info("Calling setCode function from Country class with code: {}",code);
        this.code = code;
    }
}
