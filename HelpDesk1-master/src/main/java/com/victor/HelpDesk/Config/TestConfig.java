package com.victor.HelpDesk.Config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.victor.HelpDesk.Service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @PostConstruct
    public void instanciaDB() {
        dbService.instanciaDB();
    }
}