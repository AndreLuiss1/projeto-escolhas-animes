package com.anime.crm.comtroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.anime.crm", "com.filme.crm"}) // Adicione os pacotes necessários
public class EscolhaanimeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EscolhaanimeApiApplication.class, args);
    }

}
