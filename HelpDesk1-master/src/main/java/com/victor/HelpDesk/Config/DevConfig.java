package com.victor.HelpDesk.Config;

import com.victor.HelpDesk.Service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration: Indica que a classe é uma classe de configuração do Spring.
@Configuration
//@Profile("Dev"): Indica que esta configuração é específica para o perfil "Dev".
@Profile("Dev")
//public class DevConfig {: Define a classe DevConfig.
public class DevConfig {


    //@Autowired: Essa anotação é usada para injetar a dependência do DBService no campo service.
    @Autowired
    //private DBService service;: Declara uma variável do tipo DBService chamada service, que será injetada pelo Spring.
    private DBService service;

    //@Value("${spring.jpa.hibernate.ddl-auto}"): Essa anotação é usada para injetar o valor da propriedade spring.jpa.hibernate.ddl-auto na variável value.
    @Value("${spring.jpa.hibernate.ddl-auto}")
    //private String value; Declara uma variável do tipo String chamada value, que será injetada pelo Spring
    // com o valor da propriedade mencionada.
    private String value;


    //@Bean: Indica que o método instanciaDB() será um bean gerenciado pelo Spring.
    @Bean
    //public boolean instanciaDB(){: Declaração do método instanciaDB() que retorna um booleano.
    public boolean instanciaDB(){
    //if(value.equals("create")){: Verifica se o valor da propriedade spring.jpa.hibernate.ddl-auto é igual a "create".
        if(value.equals("create")){
           // this.service.instanciaDB();: Chama o método instanciaDB() do objeto service injetado se o valor da propriedade
            // for "create".
            this.service.instanciaDB();
        }
        //return false;: Retorna false. Este retorno é irrelevante, já que o método não está sendo usado como bean para
        // ser invocado pelo Spring. A lógica desse método parece estar focada na execução de uma ação (instanciar um banco
        // de dados, provavelmente) baseada no valor da propriedade spring.jpa.hibernate.ddl-auto.
        return false;
    }
}
