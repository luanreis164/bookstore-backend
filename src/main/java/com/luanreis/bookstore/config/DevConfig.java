package com.luanreis.bookstore.config;

import com.luanreis.bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//CLASSE DE CONFIGURAÇÃO DE PERFIL PARA DEV -
//@CONFIGURATION DEFINE QUE É UMA CLASSE DE CONFIGURAÇÃO & @PROFILE DEFINE O NOME DO PERFIL;
@Configuration
@Profile("dev")
public class DevConfig {

    //INJETANDO SERVIÇO DE BANCO DE DADOS
    @Autowired
    private DBService dbService;

    //MANEIRA DE IMPORTAR ATRIBUTO GLOBAL
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    //BEAN DEFINE QUE VAI SER UM ''METODO INJETAVEL'' POR UMA CLASSE DE SERVIÇO/COMPONENTE.
    @Bean
    public boolean instantiateDatabase(){
        if(strategy.equals("create")){
            dbService.instatiateDatabase();
        }
        return false;
    }


}
