package com.dbexamples.queryingandmodifyingdb;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class SeeDb {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){
        jdbcTemplate.update("insert into RECIPES (name) values (?)", new Object[]{"Yogurt casserole"});
        jdbcTemplate.update("insert into RECIPES (name) values (?)", new Object[]{"Lassagnas"});
        jdbcTemplate.update("insert into RECIPES (name) values (?)", new Object[]{"Baklava"});
    }
}
