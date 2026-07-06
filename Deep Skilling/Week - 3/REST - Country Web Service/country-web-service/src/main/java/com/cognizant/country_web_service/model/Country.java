package com.cognizant.country_web_service.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger logger = LoggerFactory.getLogger(Country.class);
    private String code;
    private String name;

    public String getCode() {
        logger.info("The Country code is : {}",code);
        return code;
    }

    public void setCode(String code) {
        logger.info("Setting the Country code as : {}",code);
        this.code = code;
    }

    public String getName() {
        logger.info("the Country name is: {}",name);
        return name;
    }

    public void setName(String name) {
        logger.info("Setting the Country name as: {}",name);
        this.name = name;
    }

    @Override
    public String toString(){
        logger.info("toString method from Country class ");
        return " From Country class -> [ " + code + " : " + name + " ] ";
    }
}

