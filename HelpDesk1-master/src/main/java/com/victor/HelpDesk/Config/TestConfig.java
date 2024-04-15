package com.victor.HelpDesk.Config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.victor.HelpDesk.Service.DBService;


//@Configuration: Indica que a classe é uma classe de configuração do Spring.
@Configuration
//@Profile("test"): Indica que esta configuração é específica para o perfil "test".
@Profile("test")
//public class TestConfig {: Define a classe TestConfig.
public class TestConfig {
    //@Autowired private DBService dbService;: Injeta o serviço DBService.
    @Autowired
    private DBService dbService;


    //@PostConstruct: Indica que o método instanciaDB() deve ser executado após a construção do bean.
    @PostConstruct
    //public void instanciaDB() { ... }: Define o método instanciaDB() que será executado após a construção do bean.
    public void instanciaDB() {
        dbService.instanciaDB();
    }
   // dbService.instanciaDB();: Chama o método instanciaDB() do serviço DBService, que provavelmente será responsável por inicializar o banco de dados ou realizar alguma operação relacionada.
}