package com.haiss.shoppingcart;

import com.haiss.shoppingcart.util.DataSeeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ShoppingCartApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShoppingCartApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(DataSeeder seeder) {
        return args -> {
//            please manually create on your mysql database ( shopping_cart) db
            seeder.seedData();
        };
    }

}
