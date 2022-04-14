package com.luanreis.bookstore.config;

import com.luanreis.bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//CLASSE DE CONFIGURAÇÃO DE PERFIL PARA TESTE -
//@CONFIGURATION DEFINE QUE É UMA CLASSE DE CONFIGURAÇÃO & @PROFILE DEFINE O NOME DO PERFIL;
@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    //BEAN DEFINE QUE VAI SER UM ''METODO INJETAVEL'' - DEPENDENCIA.
    @Bean
    public void instantiateDatabase(){
        dbService.instatiateDatabase();
    }


}
