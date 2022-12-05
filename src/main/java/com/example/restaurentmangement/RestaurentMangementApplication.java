package com.example.restaurentmangement;

import com.example.restaurentmangement.dao.BanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurentMangementApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurentMangementApplication.class, args);
    }
}
