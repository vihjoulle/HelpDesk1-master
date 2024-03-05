package com.victor.HelpDesk.Config;

import com.victor.HelpDesk.Service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instanciaDB(){
        this.dbService.instanciaDB();
        return false;
    }
}
